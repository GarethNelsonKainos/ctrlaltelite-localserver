package uk.nhs.hackathon.ctrlaltelite.localserver.inbound;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.nhs.hackathon.ctrlaltelite.localserver.core.Core;

@RestController
@RequestMapping(consumes = "application/json", produces = "application/json")
public class RestApiClientAdapter {
    private final Core core;

    public RestApiClientAdapter(Core core) {
        this.core = core;
    }

    @PostMapping("/question")
    public ResponseEntity<TriageResponse> getNextStep(@RequestBody TriageRequest request) {
        return ResponseEntity.ok(core.getNextQuestion(request));
    }
}
