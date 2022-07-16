package org.sofka.application;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.jboss.logging.Logger;
import org.sofka.application.connection.Connection;
import org.sofka.application.controller.QuestionManager;

import java.util.Scanner;


public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    static Scanner scanner = new Scanner(System.in);
    static QuestionManager questionManager = new QuestionManager();
    public static void main(String[] args) throws JsonProcessingException {
        new Connection();
        menu();
        questionManager.questions();
        Integer option = scanner.nextInt();
        var correct = questionManager.getQuestion(option);
        System.out.println(correct);
    }

    private static void menu(){
        logger.info("""
                --------Estas en el juego de quien quiere ser millonario----------
                Por favor selecciona la respuesta correcta de acuerdo a la pregunta:
                """);

    }
}
