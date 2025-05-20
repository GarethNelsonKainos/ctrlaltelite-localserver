package uk.nhs.hackathon.ctrlaltelite.localserver.inbound;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.nhs.hackathon.ctrlaltelite.localserver.core.Core;
import uk.nhs.hackathon.ctrlaltelite.localserver.core.TxQuestion;

@RestController
@RequestMapping(consumes = "application/json", produces = "application/json")
public class RestApiClientAdapter {
    private final Core core;

    public RestApiClientAdapter(Core core) {
        this.core = core;
    }

    @GetMapping("/question")
    public ResponseEntity<TxQuestion> getNextPathways() {
        return ResponseEntity.ok(core.getNextQuestion());
    }
}
