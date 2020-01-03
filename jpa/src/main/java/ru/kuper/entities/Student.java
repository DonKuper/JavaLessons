package ru.kuper.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Setter
@Getter
public class Student {

    @Id @GeneratedValue
    int id;
    private String name;
    private int age;
    private Date birth;

    public Student(String name, int age, Date birth) {
        this.name = name;
        this.age = age;
        this.birth = birth;
    }

    public Student(){};
}
