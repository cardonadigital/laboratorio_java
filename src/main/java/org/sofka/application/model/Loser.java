package org.sofka.application.model;

import org.sofka.application.model.abstractClass.Person;

/**
 * This class contains the attributes and methods of the loser user
 *
 * @author Andres Camilo Díaz - Daniel David Cardona Moreno
 * @version 1.0.0 17/07/2022
 * @since 1.0.0
 */

public class Loser extends Person {

    public Loser(String name, Integer age, Integer score) {
        super(name, age, score);
    }

    @Override
    public String message() {
        return "------------------------------------------------\n" +
                "Cordial saludo " + getName() + " de " + getAge() + " años, lastimosamente has perdido\n" +
                "score final: " + getScore();
    }
}
