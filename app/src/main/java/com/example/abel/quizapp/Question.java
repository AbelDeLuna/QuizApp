package com.example.abel.quizapp;

import java.util.List;

public class Question {

    private static int questionsCount = 0;

    private int id;
    private String questionText;
    private Answer[] answerList;

    private int questionIcon;
    private String googleHint;

    public static final Question[] questions = {
            new Question("Q1 Text ?", new Answer[]{
                    new Answer("Answer A1"),
                    new Answer("Answer B1"),
                    new Answer("Answer C1"),
                    new Answer("Answer D1"),
                    new Answer("Andwer E1")
            }),
            new Question("Q2 Text ?", new Answer[]{
                    new Answer("Answer A2"),
                    new Answer("Answer B2"),
                    new Answer("Answer C2"),
                    new Answer("Answer D2"),
                    new Answer("Andwer E2")
            }),
            new Question("Q3 Text ?", new Answer[]{
                    new Answer("Answer A3"),
                    new Answer("Answer B3"),
                    new Answer("Answer C3"),
                    new Answer("Answer D3"),
                    new Answer("Andwer E3")
            }),
            new Question("Q4 Text ?", new Answer[]{
                    new Answer("Answer A4"),
                    new Answer("Answer B4"),
                    new Answer("Answer C4"),
                    new Answer("Answer D4"),
                    new Answer("Andwer E4")
            }),
            new Question("Q5 Text ?", new Answer[]{
                    new Answer("Answer A5"),
                    new Answer("Answer B5"),
                    new Answer("Answer C5"),
                    new Answer("Answer D5"),
                    new Answer("Andwer E5")
            }),
            new Question("Q6 Text ?", new Answer[]{
                    new Answer("Answer A6"),
                    new Answer("Answer B6"),
                    new Answer("Answer C6"),
                    new Answer("Answer D6"),
                    new Answer("Andwer E6")
            }),
            new Question("Q7 Text ?", new Answer[]{
                    new Answer("Answer A7"),
                    new Answer("Answer B7"),
                    new Answer("Answer C7"),
                    new Answer("Answer D7"),
                    new Answer("Andwer E7")
            }),
            new Question("Q8 Text ?", new Answer[]{
                    new Answer("Answer A8"),
                    new Answer("Answer B8"),
                    new Answer("Answer C8"),
                    new Answer("Answer D8"),
                    new Answer("Andwer E8")
            }),
            new Question("Q9 Text ?", new Answer[]{
                    new Answer("Answer A9"),
                    new Answer("Answer B9"),
                    new Answer("Answer C9"),
                    new Answer("Answer D9"),
                    new Answer("Andwer E9")
            }),
            new Question("Q10 Text ?", new Answer[]{
                    new Answer("Answer A10"),
                    new Answer("Answer B10"),
                    new Answer("Answer C10"),
                    new Answer("Answer D10"),
                    new Answer("Andwer E10")
            })
    };

    public Question(String newQuestion, Answer[] answers) {
        questionsCount++;
        this.id = questionsCount;
        this.questionText = newQuestion;
        this.answerList = answers;

        this.questionIcon = R.drawable.questionmark;
        this.googleHint = "google";
    }

    public Question(String newQuestion, Answer[] answers, int newIcon) {
        this(newQuestion, answers);

        this.questionIcon = newIcon;
    }

    public Question(String newQuestion, Answer[] answers, int newIcon, String newHint) {
        this(newQuestion, answers, newIcon);

        this.googleHint = newHint;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Answer[] getAnswerList() {
        return answerList;
    }

    public int getQuestionIcon() {
        return questionIcon;
    }

    public String getGoogleHint() {
        return googleHint;
    }

    public int getQuestionsCount() {
        return questionsCount;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public String toString() {
        return this.questionText;
    }

}
