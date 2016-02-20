package com.example.abel.quizapp;

public class Answer {

    private String answerText;

    private int answerIcon;

    public Answer(String newAnswer) {
        this.answerText = newAnswer;

        this.answerIcon = R.drawable.questionmark;
    }

    public Answer(String newAnswer, int newIcon) {
        this(newAnswer);

        this.answerIcon = newIcon;
    }

    public String getAnswerText() {
        return answerText;
    }

    public int getAnswerIcon() {
        return answerIcon;
    }

}
