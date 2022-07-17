package org.sofka.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.jboss.logging.Logger;
import org.sofka.application.connection.Connection;
import org.sofka.application.controller.QuestionManager;
import org.sofka.application.model.Loser;
import org.sofka.application.model.Winner;

import java.util.Scanner;


/**
 * This class contains entry point to the app and execute the menu
 *
 * @author Andres Camilo Díaz - Daniel David Cardona Moreno
 * @version 1.0.0 17/07/2022
 * @since 1.0.0
 */

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    static Scanner scanner = new Scanner(System.in);
    static Connection connection;

    static {
        connection = new Connection();
    }

    static QuestionManager questionManager = new QuestionManager();
    static Integer page = 1;
    static String name;
    static Integer age;
    static Integer score = 0;
    static Boolean exit = false;

    /**
     * call the functions for the connection to database and the user menu
     *
     * @param args
     * @throws JsonProcessingException
     * @author Andres Camilo Díaz - Daniel David Cardona Moreno
     * @version 1.0.0 17/07/2022
     * @since 1.0.0
     */
    public static void main(String[] args) throws JsonProcessingException {
        connection.connection();
        questionManager.questions();
        menu();
    }

    /**
     * user menu (capture name and age of the user and execute submenu)
     *
     * @author Andres Camilo Díaz - Daniel David Cardona Moreno
     * @version 1.0.0 17/07/2022
     * @since 1.0.0
     */
    private static void menu() {
        do {
            logger.info("--------------------------\n" +
                    "Ingrese nombre y luego la edad");
            name = scanner.nextLine();
            age = scanner.nextInt();
            submenu();
            logger.info("----------------------------\n" +
                    "oprime 1 si quieres salir, 2 si quieres seguir");
            Integer option = scanner.nextInt();
            if (option == 1) {
                exit = true;
            } else {
                page = 1;
                scanner.nextLine();
                logger.info("el juego se ha reniciado");
            }


        } while (!exit);
    }

    /**
     * This method executes each level of the game and process different states:
     * (if the user put the correct answer then go to the next level and add 5 points to the score)
     * (if the user reach the last level and put the right answer win the game)
     * (if the user put the incorrect answer lose the game)
     *
     * @author Andres Camilo Díaz - Daniel David Cardona Moreno
     * @version 1.0.0 17/07/2022
     * @since 1.0.0
     */
    private static void submenu() {
        String message = """
                --------Estas en el juego de quien quiere ser millonario----------
                Estas en el nivel: %s
                ------------------------------------------------------------------
                """.formatted(page);
        logger.info(message);
        var correct = questionManager.getQuestion(page);
        if (correct) {
            if (page == 5) {
                Winner winner = new Winner(name, age, score);
                String userMessage = winner.message();
                connection.insertDocument(name, age, score);
                logger.info(userMessage);
            } else {
                page += 1;
                score += 5;
                submenu();
            }
        } else {
            Loser loser = new Loser(name, age, score);
            String userMessage = loser.message();
            connection.insertDocument(name, age, score);
            logger.info(userMessage);
            page = 1;
            score = 0;
        }
    }

}
