package org.sofka.application.model;

import org.sofka.application.model.interfaces.QuestionInterface;

public class QuestionModel implements QuestionInterface {
    private String ask;
    private Integer category;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String correctAnswer;


    @Override
    public String getAsk() {
        return ask;
    }
    @Override
    public Integer getCategory() {
        return category;
    }
    @Override
    public String getAnswerA() {
        return answerA;
    }
    @Override
    public String getAnswerB() {
        return answerB;
    }
    @Override
    public String getAnswerC() {
        return answerC;
    }
    @Override
    public String getAnswerD() {
        return answerD;
    }
    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }


}
