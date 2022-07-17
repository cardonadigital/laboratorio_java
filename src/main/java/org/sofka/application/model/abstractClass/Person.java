package org.sofka.application.model.abstractClass;

/**
 * This class contains the abstract class person which stores the name-age-score
 *
 * @author Andres Camilo Díaz - Daniel David Cardona Moreno
 * @version 1.0.0 17/07/2022
 * @since 1.0.0
 */

public abstract class Person {
    private String name;
    private Integer age;
    private Integer score;

    public String getName() {
        return name;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getScore() {
        return score;
    }

    public Person(String name, Integer age, Integer score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public abstract String message();
}
