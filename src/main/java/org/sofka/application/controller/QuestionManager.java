package org.sofka.application.controller;
import org.sofka.application.connection.Connection;
import org.sofka.application.model.QuestionModel;

import java.util.ArrayList;
import java.util.List;


public class QuestionManager {
    List<QuestionModel> level1 = new ArrayList<>();
    List<QuestionModel> level2 = new ArrayList<>();
    List<QuestionModel> level3 = new ArrayList<>();
    List<QuestionModel> level4 = new ArrayList<>();
    List<QuestionModel> level5 = new ArrayList<>();

    public void questions(){
        var questions = Connection.getQuestions();
        for (int i = 0; i < 5; i++) {
            level1.add(questions.get(i));
        }
        for (int i = 5; i < 10; i++) {
            level2.add(questions.get(i));
        }
        for (int i = 10; i < 15; i++) {
            level3.add(questions.get(i));
        }
        for (int i = 15; i < 20; i++) {
            level4.add(questions.get(i));
        }
        for (int i = 20; i < 25; i++) {
            level5.add(questions.get(i));
        }
    }

    public void addQuestionsLevel1(Integer page){

    }
}
