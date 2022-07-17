package org.sofka.application.model.abstractClass;

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
