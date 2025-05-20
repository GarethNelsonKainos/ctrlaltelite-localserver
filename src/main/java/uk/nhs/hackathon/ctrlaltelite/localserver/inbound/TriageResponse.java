package uk.nhs.hackathon.ctrlaltelite.localserver.inbound;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TriageResponse {
    private String id;
    private String wording;
    private Map<Integer, String> answers;
    private String dxCode;
    private String dxDescription;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    public Map<Integer, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Integer, String> answers) {
        this.answers = answers;
    }

    public String getDxCode() {
        return dxCode;
    }

    public void setDxCode(String dxCode) {
        this.dxCode = dxCode;
    }

    public String getDxDescription() {
        return dxDescription;
    }

    public void setDxDescription(String dxDescription) {
        this.dxDescription = dxDescription;
    }
}
