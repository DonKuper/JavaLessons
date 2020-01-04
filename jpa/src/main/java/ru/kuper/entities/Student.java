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

    @EmbeddedId
    StudId studId;


    @Id
    int id;
    @Column(table = "students")
    private String name;
    @Column(table = "students")
    private int age;
    @Column(table = "students")
    private Date birth;

    public Student(String name, int age, Date birth) {
        this.name = name;
        this.age = age;
        this.birth = birth;
    }

    public Student(){};

}

class StudId implements Serializable {
    String name;
    String surName;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudId studId = (StudId) o;
        return Objects.equals(name, studId.name) &&
                Objects.equals(surName, studId.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName);
    }
}
