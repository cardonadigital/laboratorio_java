package org.sofka.application.model;

import org.sofka.application.model.abstractClass.Person;

public class Winner extends Person {

    public Winner(String name, Integer age, Integer score) {
        super(name, age, score);
    }

    @Override
    public String message() {
        return "Felicidades " + getName() + " de " + getAge() + " años, \n" +
                "eres el feliz ganador de un premio de 1 millon de bolvivares \n" +
                "score final: " + getScore();
    }
}
