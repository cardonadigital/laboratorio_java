package org.sofka.application.controller;

import org.sofka.application.connection.Connection;
import org.sofka.application.model.QuestionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class QuestionManager {
    Random rand = new Random();

    List<QuestionModel> level1 = new ArrayList<>();
    List<QuestionModel> level2 = new ArrayList<>();
    List<QuestionModel> level3 = new ArrayList<>();
    List<QuestionModel> level4 = new ArrayList<>();
    List<QuestionModel> level5 = new ArrayList<>();

    //arreglar esto depsues
    public void questions() {
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

    public void getQuestion(Integer page) {
        var randomNumber = getRandomNumber();
        switch (page) {
            case 1:
                var questionLevel1 = level1.get(randomNumber);
                /// mostrar menu
                //verificar respuesta seleccionada (guardar variable en numero )
                //a
                //b
                //c
                //d
                //e

                System.out.println(questionLevel1.getAsk());
                break;

            case 2:
                var questionLevel2 = level2.get(randomNumber);
                System.out.println(questionLevel2.getAsk());
                break;

            case 3:
                var questionLevel3 = level3.get(randomNumber);
                System.out.println(questionLevel3.getAsk());
                break;

            case 4:
                var questionLevel4 = level4.get(randomNumber);
                System.out.println(questionLevel4.getAsk());
                break;

            case 5:
                var questionLevel5 = level5.get(randomNumber);
                System.out.println(questionLevel5.getAsk());
                break;

            default:
                System.out.println("numero invalido");
                break;
        }
    }

    private Integer getRandomNumber() {
        return rand.nextInt(4 + 1);
    }

    private void  getInfo(){

    }
}
