package uk.nhs.hackathon.ctrlaltelite.localserver.core;

import org.springframework.stereotype.Component;
import uk.nhs.hackathon.ctrlaltelite.localserver.inbound.TriageDisposition;
import uk.nhs.hackathon.ctrlaltelite.localserver.inbound.TriageQuestion;
import uk.nhs.hackathon.ctrlaltelite.localserver.inbound.TriageRequest;
import uk.nhs.hackathon.ctrlaltelite.localserver.inbound.TriageResponse;

import java.util.HashMap;
import java.util.Map;

@Component
public class InternalTriageEngine {
    private static final Map<String, String> dispositions = Map.of(
            "DxGoToVet", "Self-referral to veterinary clinic",
            "DxBlue", "Eye-hue privilege - enjoy life",
            "DxBrown", "So basic",
            "DxNA", "Self-referral to beautician for fake eye makeup"
    );

    private TxPathways pathways;

    public void setPathways(TxPathways pathways) {
        this.pathways = pathways;
    }


    public TriageResponse triage(TriageRequest request) {
        TxPathway pathway = pathways.getPathways().get("PWDemo");
        int orderNumber = 0;
        TxQuestion q = pathway.getOrderNumbersToQuestions().get(orderNumber);
        while (true) {
            String questionId = q.getId();
            Integer answerNumber = request.answers().get(questionId);
            if (answerNumber != null) {
                String jumpId = q.getAnswers().get(answerNumber).getJumpId();
                try {
                    int jump = Integer.parseInt(jumpId);
                    q = pathway.getOrderNumbersToQuestions().get(jump);
                } catch (NumberFormatException e) {
                    return new TriageDisposition(jumpId, dispositions.get(jumpId));
                }
            } else {
                return new TriageQuestion(q.getId(), q.getWording(), convertAnswers(q.getAnswers()));
            }
        }
    }

    private Map<Integer, String> convertAnswers(Map<Integer, TxAnswer> answers) {
        Map<Integer, String> result = new HashMap<>();

        for (Map.Entry<Integer, TxAnswer> entry : answers.entrySet()) {
            result.put(entry.getKey(), entry.getValue().getText());
        }

        return result;
    }
}
