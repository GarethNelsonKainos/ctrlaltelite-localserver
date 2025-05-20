package uk.nhs.hackathon.ctrlaltelite.localserver.outbound;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;
import uk.nhs.hackathon.ctrlaltelite.localserver.core.TxPathways;

@Repository
public class RestApiCentralAdapter {

    private final RestClient restClient;

    public RestApiCentralAdapter(RestClient.Builder restClientBuilder) {
        restClient = restClientBuilder
                .baseUrl("http://localhost:8080")
                .defaultHeader("Accept", "application/json")
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    public TxPathways getPathwaysFromCentralServer() {
        return restClient.get()
                .uri("/cache")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(TxPathways.class);
    }
}
