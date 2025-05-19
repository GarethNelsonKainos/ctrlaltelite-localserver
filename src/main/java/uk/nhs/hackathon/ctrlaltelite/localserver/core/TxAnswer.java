package uk.nhs.hackathon.ctrlaltelite.localserver.core;

public class TxAnswer {
    private final int answerNumber;
    private final String text;
    private final String jumpId;

    public TxAnswer(int answerNumber, String text, String jumpId) {
        this.answerNumber = answerNumber;
        this.text = text;
        this.jumpId = jumpId;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

    public String getText() {
        return text;
    }

    public String getJumpId() {
        return jumpId;
    }
}