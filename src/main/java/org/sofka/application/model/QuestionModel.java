package org.sofka.application.model;

import org.sofka.application.model.interfaces.QuestionInterface;

/**
 * This class contains the attributes of the Question mapped from database
 *
 * @author Andres Camilo Díaz - Daniel David Cardona Moreno
 * @version 1.0.0 17/07/2022
 * @since 1.0.0
 */

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
