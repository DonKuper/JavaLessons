package ru.kuper.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "students")
@Setter @Getter
public class Student {
    @Id @GeneratedValue
    int id;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Basic(optional = true)
    private int age;
    private Date birth;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    byte[] img;

    public Student(int age, Date birth) {
        this.age = age;
        this.birth = birth;
        gender = Gender.MALE;
    }

    public Student(){};
}

enum Gender {MALE, FEMALE}
