package org.sofka.application.model;

import org.sofka.application.model.abstractClass.Person;

public class Loser extends Person {

    public Loser(String name, Integer age, Integer score) {
        super(name, age, score);
    }

    @Override
    public String message() {
        return "Cordial saludo " + getName() + " de " + getAge() + " años, lastimosamente has perdido\n" +
                "score final: " + getScore();
    }
}
