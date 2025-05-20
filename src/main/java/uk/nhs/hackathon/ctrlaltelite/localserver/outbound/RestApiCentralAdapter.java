package uk.nhs.hackathon.ctrlaltelite.localserver.outbound;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestClient;
import uk.nhs.hackathon.ctrlaltelite.localserver.core.TxPathways;
import uk.nhs.hackathon.ctrlaltelite.localserver.inbound.TriageRequest;
import uk.nhs.hackathon.ctrlaltelite.localserver.inbound.TriageResponse;

@Repository
public class RestApiCentralAdapter {

    private final RestClient restClient;

    public RestApiCentralAdapter(RestClient.Builder restClientBuilder) {
        restClient = restClientBuilder
                .baseUrl("http://localhost:8080")
                .defaultHeader("Accept", "application/json")
                .defaultHeader("Content-Type", "application/json")
                .requestFactory(getClientHttpRequestFactory())
                .build();
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(500);
        clientHttpRequestFactory.setConnectionRequestTimeout(500);
        return clientHttpRequestFactory;
    }

    public TxPathways getPathwaysFromCentralServer() {
        return restClient.get()
                .uri("/cache")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(TxPathways.class);
    }

    public TriageResponse getNextQuestionFromServer(TriageRequest triageRequest){
        return restClient.post()
                .uri("/triage")
                .body(triageRequest)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(TriageResponse.class);
    }
}
