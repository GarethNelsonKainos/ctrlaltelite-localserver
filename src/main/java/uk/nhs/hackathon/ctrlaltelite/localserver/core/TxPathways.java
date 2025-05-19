package uk.nhs.hackathon.ctrlaltelite.localserver.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TxPathways implements Serializable {
    private final Map<String, TxPathway> pathways = new HashMap<>();

    public Map<String, TxPathway> getPathways() {
        return pathways;
    }

    public void addQuestion(String pathwayId, int orderNumber, String questionId, String questionWording) {
        TxPathway pathway = pathways.get(pathwayId);
        if (pathway == null) {
            pathway = new TxPathway(pathwayId);
            pathways.put(pathwayId, pathway);
        }
        pathway.addQuestion(orderNumber, new TxQuestion(questionId, questionWording));
    }

    public void addAnswer(String pathwayId, String questionId, int answerNumber, String answerText, String jump) {
        pathways.get(pathwayId).addAnswer(questionId, answerNumber, answerText, jump);
    }

    // Todo: implement getter
    public getQuestion(){

    }
}