package org.sofka.application.model.interfaces;

/**
 * This Interface contains the methods to implement in class(QuestionModel)
 *
 * @author Andres Camilo Díaz - Daniel David Cardona Moreno
 * @version 1.0.0 17/07/2022
 * @since 1.0.0
 */

public interface QuestionInterface {

    //return the Question
    public String getAsk();

    //return the option a
    public String getAnswerA();

    //return the option b
    public String getAnswerB();

    //return the option c
    public String getAnswerC();

    //return the option d
    public String getAnswerD();

    //return the correct answer
    public String getCorrectAnswer();
}
