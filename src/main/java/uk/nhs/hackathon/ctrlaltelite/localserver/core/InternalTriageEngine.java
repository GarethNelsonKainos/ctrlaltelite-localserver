package uk.nhs.hackathon.ctrlaltelite.localserver.core;

import org.springframework.stereotype.Component;
import uk.nhs.hackathon.ctrlaltelite.localserver.inbound.TriageRequest;
import uk.nhs.hackathon.ctrlaltelite.localserver.inbound.TriageResponse;

import java.util.HashMap;
import java.util.Map;

@Component
public class InternalTriageEngine {
    private static final Map<String, String> dispositions = Map.of(
            "Dx011", "Emergency Ambulance Response",
            "Dx111", "Handoff to 111",
            "Dx001", "Referred to Primary Care for further assessment"
    );

    private TxPathways pathways;

    public void setPathways(TxPathways pathways) {
        this.pathways = pathways;
    }


    public TriageResponse triage(TriageRequest request) {
        TxPathway pathway = pathways.getPathways().get("PWUnder5");
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
                    TriageResponse response = new TriageResponse();
                    response.setDxCode(jumpId);
                    response.setDxDescription(dispositions.get(jumpId));
                    return response;
                }
            } else {
                TriageResponse response = new TriageResponse();
                response.setId(q.getId());
                response.setWording(q.getWording());
                response.setAnswers(convertAnswers(q.getAnswers()));
                return response;
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
