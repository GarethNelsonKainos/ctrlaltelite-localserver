package uk.nhs.hackathon.ctrlaltelite.localserver.core;

import java.util.HashMap;
import java.util.Map;

public class TxQuestion {
    private final String id;
    private final String wording;
    private final Map<Integer, TxAnswer> answers = new HashMap<>();

    public TxQuestion(String id, String wording) {
        this.id = id;
        this.wording = wording;
    }

    public String getId() {
        return id;
    }

    public String getWording() {
        return wording;
    }

    public Map<Integer, TxAnswer> getAnswers() {
        return answers;
    }

    public void addAnswer(int position, TxAnswer answer) {
        answers.put(position, answer);
    }
}