package ru.kuper.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {
    @Id @GeneratedValue
    int id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String name;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    byte[] img;

    public Student(String name, Date birth) {
        this.name = name;
        gender = Gender.MALE;
    }

    public Student(){};

    @Access(AccessType.PROPERTY)
    public String getName() {
        return "Mr. " + name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

enum Gender {MALE, FEMALE}
