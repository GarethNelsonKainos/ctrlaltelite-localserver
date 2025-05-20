package uk.nhs.hackathon.ctrlaltelite.localserver.inbound;

import java.util.Map;

public record TriageRequest(
        String skillset,
        int ageInYears,
        String gender, // "M" or "F"
        int party,
        Map<String, Integer> answers
) {
}
