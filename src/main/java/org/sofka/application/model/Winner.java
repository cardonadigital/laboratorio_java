package org.sofka.application.model;

import org.sofka.application.model.abstractClass.Person;

/**
 * This class contains the attributes and methods of the winner user
 *
 * @author Andres Camilo Díaz - Daniel David Cardona Moreno
 * @version 1.0.0 17/07/2022
 * @since 1.0.0
 */

public class Winner extends Person {

    public Winner(String name, Integer age, Integer score) {
        super(name, age, score);
    }

    @Override
    public String message() {
        return "--------------------------------------------------------------\n" +
                "Felicidades " + getName() + " de " + getAge() + " años, \n" +
                "eres el feliz ganador de un premio de 1 millon de bolvivares \n" +
                "score final: " + getScore();
    }
}
