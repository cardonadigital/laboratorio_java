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
    static Integer page = 1;

    public static void main(String[] args) throws JsonProcessingException {
        new Connection();
        questionManager.questions();
        menu();

    }

    private static void menu(){
        String message = """
                --------Estas en el juego de quien quiere ser millonario----------
                Estas en el nivel: %s
                """.formatted(page);
        logger.info(message);
        /*Integer page = scanner.nextInt();*/
        var correct = questionManager.getQuestion(page);
        if (correct){
            if (page == 5){
                System.out.println("has ganado");
            } else{
                page +=1;
                menu();
            }
        } else{
            page = 1;
            menu();
        }

    }
}
