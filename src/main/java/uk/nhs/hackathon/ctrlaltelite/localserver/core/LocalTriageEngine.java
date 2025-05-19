package uk.nhs.hackathon.ctrlaltelite.localserver.core;

import uk.nhs.hackathon.ctrlaltelite.localserver.outbound.RestApiCentralAdapter;

public class LocalTriageEngine {
    private final RestApiCentralAdapter adapter;
    private TxPathways pathways;
    public LocalTriageEngine(RestApiCentralAdapter adapter) {
        this.adapter = adapter;
    }

    public void getAllPathwaysForCaching() {
        this.pathways = adapter.getPathwaysFromCentralServer();
    }

    public TxQuestion getNextQuestion() {
        // Todo: Implement logic to retrieve next question

        return new TxQuestion("id", "wording");
    }
}
