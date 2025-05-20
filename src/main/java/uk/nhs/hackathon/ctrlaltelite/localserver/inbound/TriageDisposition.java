package uk.nhs.hackathon.ctrlaltelite.localserver.inbound;

public final class TriageDisposition extends TriageResponse {
    private String dxCode;
    private String dxDescription;

    public TriageDisposition(String dxCode, String dxDescription) {
        this.dxCode = dxCode;
        this.dxDescription = dxDescription;
    }

    public String getDxCode() {
        return dxCode;
    }

    public String getDxDescription() {
        return dxDescription;
    }
}
