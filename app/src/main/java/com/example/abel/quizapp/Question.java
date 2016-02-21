package com.example.abel.quizapp;

public class Question {

    public static final String EXTRA_QUESTION_NO = "qn";

    private static int questionsCount = 0;

    private int id;
    private String questionTitle;
    private String questionText;
    private Answer[] answerList;
    private int correctAnswerNumber;

    private int questionIcon;
    private String googleHint;

    public static final Question[] questions = {
            new Question("Question 1", "What is the answer of the question #1?", new Answer[]{
                    new Answer("Answer A1"),
                    new Answer("Answer B1"),
                    new Answer("Answer C1"),
                    new Answer("Answer D1"),
                    new Answer("Answer E1")
            }, 0),
            new Question("Question 2", "What is the answer of the question #2?", new Answer[]{
                    new Answer("Answer A2"),
                    new Answer("Answer B2"),
                    new Answer("Answer C2"),
                    new Answer("Answer D2"),
                    new Answer("Answer E2")
            }, 1),
            new Question("Question 3", "What is the answer of the question #3?", new Answer[]{
                    new Answer("Answer A3"),
                    new Answer("Answer B3"),
                    new Answer("Answer C3"),
                    new Answer("Answer D3"),
                    new Answer("Answer E3")
            }, 2),
            new Question("Question 4", "What is the answer of the question #4?", new Answer[]{
                    new Answer("Answer A4"),
                    new Answer("Answer B4"),
                    new Answer("Answer C4"),
                    new Answer("Answer D4"),
                    new Answer("Answer E4")
            }, 3),
            new Question("Question 5", "What is the answer of the question #5?", new Answer[]{
                    new Answer("Answer A5"),
                    new Answer("Answer B5"),
                    new Answer("Answer C5"),
                    new Answer("Answer D5"),
                    new Answer("Answer E5")
            }, 4),
            new Question("Question 6", "What is the answer of the question #6?", new Answer[]{
                    new Answer("Answer A6"),
                    new Answer("Answer B6"),
                    new Answer("Answer C6"),
                    new Answer("Answer D6"),
                    new Answer("Answer E6")
            }, 4),
            new Question("Question 7", "What is the answer of the question #7?", new Answer[]{
                    new Answer("Answer A7"),
                    new Answer("Answer B7"),
                    new Answer("Answer C7"),
                    new Answer("Answer D7"),
                    new Answer("Answer E7")
            }, 3),
            new Question("Question 8", "What is the answer of the question #8?", new Answer[]{
                    new Answer("Answer A8"),
                    new Answer("Answer B8"),
                    new Answer("Answer C8"),
                    new Answer("Answer D8"),
                    new Answer("Answer E8")
            }, 2),
            new Question("Question 9", "What is the answer of the question #9?", new Answer[]{
                    new Answer("Answer A9"),
                    new Answer("Answer B9"),
                    new Answer("Answer C9"),
                    new Answer("Answer D9"),
                    new Answer("Answer E9")
            }, 1),
            new Question("Question 10", "What is the answer of the question #10?", new Answer[]{
                    new Answer("Answer A10"),
                    new Answer("Answer B10"),
                    new Answer("Answer C10"),
                    new Answer("Answer D10"),
                    new Answer("Answer E10")
            }, 0)
    };

    public Question(String newQuestionTitle, String newQuestionText, Answer[] answers, int newCorrectAnswer) {
        questionsCount++;
        this.id = questionsCount;
        this.questionTitle = newQuestionTitle;
        this.questionText = newQuestionText;
        this.answerList = answers;
        this.correctAnswerNumber = newCorrectAnswer;

        this.questionIcon = R.drawable.questionmark;
        this.googleHint = "google";
    }

    public Question(String newQuestionTitle, String newQuestionText, Answer[] answers, int newCorrectAnswer, int newIcon) {
        this(newQuestionTitle, newQuestionText, answers, newCorrectAnswer);

        this.questionIcon = newIcon;
    }

    public Question(String newQuestionTitle, String newQuestionText, Answer[] answers, int newCorrectAnswer, int newIcon, String newHint) {
        this(newQuestionTitle, newQuestionText, answers, newCorrectAnswer, newIcon);

        this.googleHint = newHint;
    }

    public String getQuestionTitle() {
        return this.questionTitle;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public Answer[] getAnswerList() {
        return this.answerList;
    }

    public int getCorrectAnswerNumber() {
        return this.correctAnswerNumber;
    }

    public int getQuestionIcon() {
        return this.questionIcon;
    }

    public String getGoogleHint() {
        return this.googleHint;
    }

    public int getQuestionsCount() {
        return this.questionsCount;
    }

    public Question[] getQuestions() {
        return this.questions;
    }

    public String toString() {
        return this.questionTitle;
    }

}
