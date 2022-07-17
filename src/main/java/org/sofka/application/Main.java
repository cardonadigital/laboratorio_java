package org.sofka.application;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.jboss.logging.Logger;
import org.sofka.application.connection.Connection;
import org.sofka.application.controller.QuestionManager;
import org.sofka.application.model.Loser;
import org.sofka.application.model.Winner;
import org.sofka.application.model.abstractClass.Person;

import java.util.Scanner;


public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    static Scanner scanner = new Scanner(System.in);
    static QuestionManager questionManager = new QuestionManager();
    static Integer page = 1;
    static String name;
    static Integer age;
    static Integer score;

    public static void main(String[] args) throws JsonProcessingException {
        new Connection();
        /*new Connection().insertDocument("daniel", 25, 20 );*/
        questionManager.questions();
        menu();


    }

    private static void menu(){
        logger.info("Ingrese nombre y luego la edad");
        name = scanner.nextLine();
        age = scanner.nextInt();
        submenu();
    }

    private static void submenu(){
        String message = """
                --------Estas en el juego de quien quiere ser millonario----------
                Estas en el nivel: %s
                """.formatted(page);
        logger.info(message);
        var correct = questionManager.getQuestion(page);
        if (correct){
            if (page == 5){
                Winner winner = new Winner(name, age, score);
                String userMessage = winner.message();
                System.out.println(userMessage);
            } else{
                page +=1;
                submenu();
            }
        } else{
            Loser loser = new Loser(name, age, score);
            String userMessage = loser.message();
            System.out.println(userMessage);
            page = 1;
            score = 0;
        }
    }

}
