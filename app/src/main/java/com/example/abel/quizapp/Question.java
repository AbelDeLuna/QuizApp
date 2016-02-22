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
                    new Answer("Answer A1", R.drawable.pizza),
                    new Answer("Answer B1", R.drawable.xbox),
                    new Answer("Answer C1", R.drawable.twitch),
                    new Answer("Answer D1", R.drawable.twitter),
                    new Answer("Answer E1", R.drawable.playstation)
            }, 0, R.drawable.one),
            new Question("Question 2", "What is the answer of the question #2?", new Answer[]{
                    new Answer("Answer A2", R.drawable.twitter),
                    new Answer("Answer B2", R.drawable.youtube),
                    new Answer("Answer C2", R.drawable.soccer),
                    new Answer("Answer D2", R.drawable.web),
                    new Answer("Answer E2", R.drawable.water)
            }, 1, R.drawable.two),
            new Question("Question 3", "What is the answer of the question #3?", new Answer[]{
                    new Answer("Answer A3", R.drawable.pizza),
                    new Answer("Answer B3", R.drawable.xbox),
                    new Answer("Answer C3", R.drawable.twitch),
                    new Answer("Answer D3", R.drawable.twitter),
                    new Answer("Answer E3", R.drawable.playstation)
            }, 2, R.drawable.three),
            new Question("Question 4", "What is the answer of the question #4?", new Answer[]{
                    new Answer("Answer A4", R.drawable.twitter),
                    new Answer("Answer B4", R.drawable.youtube),
                    new Answer("Answer C4", R.drawable.soccer),
                    new Answer("Answer D4", R.drawable.web),
                    new Answer("Answer E4", R.drawable.water)
            }, 3, R.drawable.four),
            new Question("Question 5", "What is the answer of the question #5?", new Answer[]{
                    new Answer("Answer A5", R.drawable.pizza),
                    new Answer("Answer B5", R.drawable.xbox),
                    new Answer("Answer C5", R.drawable.twitch),
                    new Answer("Answer D5", R.drawable.twitter),
                    new Answer("Answer E5", R.drawable.playstation)
            }, 4, R.drawable.five),
            new Question("Question 6", "What is the answer of the question #6?", new Answer[]{
                    new Answer("Answer A6", R.drawable.pizza),
                    new Answer("Answer B6", R.drawable.xbox),
                    new Answer("Answer C6", R.drawable.twitch),
                    new Answer("Answer D6", R.drawable.twitter),
                    new Answer("Answer E6", R.drawable.playstation)
            }, 4, R.drawable.six),
            new Question("Question 7", "What is the answer of the question #7?", new Answer[]{
                    new Answer("Answer A7", R.drawable.twitter),
                    new Answer("Answer B7", R.drawable.youtube),
                    new Answer("Answer C7", R.drawable.soccer),
                    new Answer("Answer D7", R.drawable.web),
                    new Answer("Answer E7", R.drawable.water)
            }, 3, R.drawable.seven),
            new Question("Question 8", "What is the answer of the question #8?", new Answer[]{
                    new Answer("Answer A8", R.drawable.twitter),
                    new Answer("Answer B8", R.drawable.youtube),
                    new Answer("Answer C8", R.drawable.soccer),
                    new Answer("Answer D8", R.drawable.web),
                    new Answer("Answer E8", R.drawable.water)
            }, 2, R.drawable.eight),
            new Question("Question 9", "What is the answer of the question #9?", new Answer[]{
                    new Answer("Answer A9", R.drawable.pizza),
                    new Answer("Answer B9", R.drawable.xbox),
                    new Answer("Answer C9", R.drawable.twitch),
                    new Answer("Answer D9", R.drawable.twitter),
                    new Answer("Answer E9", R.drawable.playstation)
            }, 1, R.drawable.nine),
            new Question("Question 10", "What is the answer of the question #10?", new Answer[]{
                    new Answer("Answer A10", R.drawable.twitter),
                    new Answer("Answer B10", R.drawable.youtube),
                    new Answer("Answer C10", R.drawable.soccer),
                    new Answer("Answer D10", R.drawable.web),
                    new Answer("Answer E10", R.drawable.water)
            }, 0, R.drawable.nineplus)
    };

    public Question(String newQuestionTitle, String newQuestionText, Answer[] answers, int newCorrectAnswer) {
        questionsCount++;
        this.id = questionsCount;
        this.questionTitle = newQuestionTitle;
        this.questionText = newQuestionText;
        this.answerList = answers;
        this.correctAnswerNumber = newCorrectAnswer;

        this.questionIcon = R.drawable.question;
        this.googleHint = "answer is " + (this.correctAnswerNumber + 1);
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
