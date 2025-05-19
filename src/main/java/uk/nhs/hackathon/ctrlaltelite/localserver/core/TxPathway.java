package uk.nhs.hackathon.ctrlaltelite.localserver.core;

import java.util.HashMap;
import java.util.Map;

public class TxPathway {
    private final String id;
    private final Map<Integer, TxQuestion> orderNumbersToQuestions = new HashMap<>();

    public TxPathway(String id) {
        this.id = id;
    }

    public void addQuestion(int orderNumber, TxQuestion question) {
        orderNumbersToQuestions.put(orderNumber, question);
    }

    public void addAnswer(String questionId, int answerNumber, String answerText, String jump) {
        TxQuestion q = orderNumbersToQuestions.values().stream().filter(txq -> txq.getId().equals(questionId)).findFirst().orElseThrow();
        q.addAnswer(answerNumber, new TxAnswer(answerNumber, answerText, jump));
    }

    public String getId() {
        return id;
    }

    public Map<Integer, TxQuestion> getOrderNumbersToQuestions() {
        return orderNumbersToQuestions;
    }
}