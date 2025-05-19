package uk.nhs.hackathon.ctrlaltelite.localserver.outbound;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import uk.nhs.hackathon.ctrlaltelite.localserver.core.TxPathways;

@Service
public class RestApiCentralAdapter {

    private final WebClient webClient;

    public RestApiCentralAdapter(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:3000").build();
    }

    public TxPathways getPathwaysFromCentralServer() {
        return (TxPathways) webClient.get()
                .uri("/cache") // Replace with actual API endpoint
                .retrieve();
    }
}
