package uk.nhs.hackathon.ctrlaltelite.localserver.core;

import org.springframework.stereotype.Service;
import uk.nhs.hackathon.ctrlaltelite.localserver.outbound.RestApiCentralAdapter;

@Service
public class Core {
    private final RestApiCentralAdapter adapter;
    private TxPathways pathways;

    public Core(RestApiCentralAdapter adapter) {
        this.adapter = adapter;
        getAllPathwaysForCaching();
    }

    public void getAllPathwaysForCaching() {
        this.pathways = adapter.getPathwaysFromCentralServer();
    }

    public TxQuestion getNextQuestion() {
        // Todo: Implement logic to retrieve next question

        return new TxQuestion("id", "wording");
    }
}
