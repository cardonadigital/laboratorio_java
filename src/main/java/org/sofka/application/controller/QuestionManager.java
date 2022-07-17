package org.sofka.application.controller;

import org.jboss.logging.Logger;
import org.sofka.application.connection.Connection;
import org.sofka.application.model.QuestionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * This class manage the logic of each question and store the questions into each level
 *
 * @author Andres Camilo Díaz - Daniel David Cardona Moreno
 * @version 1.0.0 17/07/2022
 * @since 1.0.0
 */
public class QuestionManager {
    static Scanner scanner = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(QuestionManager.class);
    Random rand = new Random();

    List<QuestionModel> level1 = new ArrayList<>();
    List<QuestionModel> level2 = new ArrayList<>();
    List<QuestionModel> level3 = new ArrayList<>();
    List<QuestionModel> level4 = new ArrayList<>();
    List<QuestionModel> level5 = new ArrayList<>();

    /**
     * This method stores the questions into the array list (level1, level2, level3, level4, level5)
     *
     * @author Andres Camilo Díaz - Daniel David Cardona Moreno
     * @version 1.0.0 17/07/2022
     * @since 1.0.0
     */

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

    /**
     * This method get the specific question for the game
     *
     * @author Andres Camilo Díaz - Daniel David Cardona Moreno
     * @version 1.0.0 17/07/2022
     * @since 1.0.0
     */
    public Boolean getQuestion(Integer page) {
        var randomNumber = getRandomNumber();
        switch (page) {
            case 1 -> {
                var questionLevel1 = level1.get(randomNumber);
                return compareAnswer(questionLevel1);
            }
            case 2 -> {
                var questionLevel2 = level2.get(randomNumber);
                return compareAnswer(questionLevel2);
            }
            case 3 -> {
                var questionLevel3 = level3.get(randomNumber);
                return compareAnswer(questionLevel3);
            }
            case 4 -> {
                var questionLevel4 = level4.get(randomNumber);
                return compareAnswer(questionLevel4);
            }
            case 5 -> {
                var questionLevel5 = level5.get(randomNumber);
                return compareAnswer(questionLevel5);
            }
            default -> logger.info("numero invalido");
        }
        return false;
    }


    /**
     * This method compare the user answer with the correct answer
     *
     * @author Andres Camilo Díaz - Daniel David Cardona Moreno
     * @version 1.0.0 17/07/2022
     * @since 1.0.0
     */
    private Boolean compareAnswer(QuestionModel question) {
        var questionAsk = question.getAsk();
        var answerA = question.getAnswerA();
        var answerB = question.getAnswerB();
        var answerC = question.getAnswerC();
        var answerD = question.getAnswerD();
        var menuQuestion = """
                ----------------------------------------
                Ingrese la opción que consideres correcta:
                            Pregunta:
                %s
                1 Opción: %s
                2 Opción: %s
                3 Opción: %s
                4 Opción: %s
                """.formatted(questionAsk, answerA, answerB, answerC, answerD);
        logger.info(menuQuestion);
        Integer userOption = scanner.nextInt();
        var correctAnswer = question.getCorrectAnswer();
        return switch (userOption) {
            case 1 -> question.getAnswerA().equals(correctAnswer);
            case 2 -> question.getAnswerB().equals(correctAnswer);
            case 3 -> question.getAnswerC().equals(correctAnswer);
            case 4 -> question.getAnswerD().equals(correctAnswer);
            default -> false;
        };
    }

    /**
     * This method gives a random number between 0-5
     *
     * @author Andres Camilo Díaz - Daniel David Cardona Moreno
     * @version 1.0.0 17/07/2022
     * @since 1.0.0
     */
    private Integer getRandomNumber() {
        return rand.nextInt(4 + 1);
    }
}
