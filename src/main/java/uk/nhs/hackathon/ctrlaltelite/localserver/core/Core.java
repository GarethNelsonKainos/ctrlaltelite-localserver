package uk.nhs.hackathon.ctrlaltelite.localserver.core;

import org.springframework.stereotype.Service;
import uk.nhs.hackathon.ctrlaltelite.localserver.inbound.TriageRequest;
import uk.nhs.hackathon.ctrlaltelite.localserver.inbound.TriageResponse;
import uk.nhs.hackathon.ctrlaltelite.localserver.outbound.RestApiCentralAdapter;

@Service
public class Core {
    private final RestApiCentralAdapter adapter;
    private final InternalTriageEngine triageEngine;

    public Core(RestApiCentralAdapter adapter, InternalTriageEngine triageEngine) {
        this.adapter = adapter;
        this.triageEngine = triageEngine;
        getAllPathwaysForCaching();
    }

    public void getAllPathwaysForCaching() {
        triageEngine.setPathways(adapter.getPathwaysFromCentralServer());
    }

    public TriageResponse getNextQuestion(TriageRequest request) {
        // Todo: Implement logic to retrieve next question

        return triageEngine.triage(request);
    }
}
