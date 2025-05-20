package uk.nhs.hackathon.ctrlaltelite.localserver.inbound;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.nhs.hackathon.ctrlaltelite.localserver.core.LocalTriageEngine;
import uk.nhs.hackathon.ctrlaltelite.localserver.core.TxQuestion;

@RestController
@RequestMapping(consumes = "application/json", produces = "application/json")
public class RestApiClientAdapter {
    private final LocalTriageEngine localTriageEngine;

    public RestApiClientAdapter(LocalTriageEngine localTriageEngine) {
        this.localTriageEngine = localTriageEngine;
    }

    @GetMapping("/question")
    public ResponseEntity<TxQuestion> getNextPathways() {
        return ResponseEntity.ok(localTriageEngine.getNextQuestion());
    }
}
