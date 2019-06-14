package com.ivanbudos.kvizkolegija;

import java.util.ArrayList;

public class QuestionModel {
    private String question;
    private String[] posibleAnswers;
    private int rightAnswer;

    public QuestionModel(String question, String[] posibleAnswers, int rightAnswer) {
        this.question = question;
        this.posibleAnswers = posibleAnswers;
        this.rightAnswer = rightAnswer;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getPosibleAnswers() {
        return posibleAnswers;
    }

    public void setPosibleAnswers(String[] posibleAnswers) {
        this.posibleAnswers = posibleAnswers;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

}
