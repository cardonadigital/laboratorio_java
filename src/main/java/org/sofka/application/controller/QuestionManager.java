package org.sofka.application.controller;
import org.sofka.application.connection.Connection;

public class QuestionManager {
    public void questions(){
        var questions = Connection.getQuestions();
        System.out.println("questions: " + questions);
    }
}
