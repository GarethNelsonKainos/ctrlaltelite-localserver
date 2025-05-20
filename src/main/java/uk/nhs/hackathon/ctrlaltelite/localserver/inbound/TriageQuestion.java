package uk.nhs.hackathon.ctrlaltelite.localserver.inbound;

import java.util.Map;

public final class TriageQuestion extends TriageResponse {
    private String id;
    private String wording;
    private Map<Integer, String> answers;

    public TriageQuestion(String id, String wording, Map<Integer, String> answers) {
        this.id = id;
        this.wording = wording;
        this.answers = answers;
    }

    public String getId() {
        return id;
    }

    public String getWording() {
        return wording;
    }

    public Map<Integer, String> getAnswers() {
        return answers;
    }
}
