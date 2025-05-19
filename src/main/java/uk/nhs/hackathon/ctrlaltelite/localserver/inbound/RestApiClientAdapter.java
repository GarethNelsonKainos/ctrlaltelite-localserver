package uk.nhs.hackathon.ctrlaltelite.localserver.inbound;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import uk.nhs.hackathon.ctrlaltelite.localserver.core.LocalTriageEngine;
import uk.nhs.hackathon.ctrlaltelite.localserver.core.TxQuestion;

public class RestApiClientAdapter {
    private final LocalTriageEngine localTriageEngine;

    public RestApiClientAdapter(LocalTriageEngine localTriageEngine) {
        this.localTriageEngine = localTriageEngine;
        localTriageEngine.getAllPathwaysForCaching();
    }

    @GetMapping("/question")
    public ResponseEntity<TxQuestion> getNextPathways() {
        return ResponseEntity.ok(localTriageEngine.getNextQuestion());
    }
}
