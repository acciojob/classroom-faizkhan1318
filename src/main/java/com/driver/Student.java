package com.driver;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Student {
    private String name;
    private int age;
    private double averageScore;
    public Student(){

    }
    public Student( String name, int age, double averageScore) {
        this.name = name;
        this.age = age;
        this.averageScore = averageScore;
    }
}
