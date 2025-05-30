package uk.nhs.hackathon.ctrlaltelite.localserver.core;

import org.springframework.stereotype.Service;
import uk.nhs.hackathon.ctrlaltelite.localserver.inbound.TriageRequest;
import uk.nhs.hackathon.ctrlaltelite.localserver.inbound.TriageResponse;
import uk.nhs.hackathon.ctrlaltelite.localserver.outbound.RestApiCentralAdapter;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Service
public class Core {
    private final RestApiCentralAdapter adapter;
    private final InternalTriageEngine triageEngine;
    private final Logger logger = LogManager.getLogger(Core.class);

    public Core(RestApiCentralAdapter adapter, InternalTriageEngine triageEngine) {
        this.adapter = adapter;
        this.triageEngine = triageEngine;
        getAllPathwaysForCaching();
    }

    public void getAllPathwaysForCaching() {
        logger.info("Loading pathways cache from central server...");
        triageEngine.setPathways(adapter.getPathwaysFromCentralServer());
        logger.info("Loading pathways cache from central server completed.");
    }

    public TriageResponse getNextQuestion(TriageRequest request) {
        try {
            logger.info("Getting next question from central triage engine...");
            return this.adapter.getNextQuestionFromServer(request);
        } catch (Exception E) {
            logger.info("Unable to get next question from central triage engine.");
            logger.info("Use local triage engine to get next question");
            return triageEngine.triage(request);
        }
    }
}
