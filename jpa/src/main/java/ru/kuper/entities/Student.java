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

    @Basic(optional = true)
    private int age;
    private Date birth;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    byte[] img;


    public Student(String name, String surName, int age, Date birth) {
        this.age = age;
        this.birth = birth;
        this.studId = new StudId(name,surName);
    }

    public Student(){};

}

@Embeddable
class StudId implements Serializable {


    private String name;
    private String surName;

    public StudId(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public StudId() {
    }

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
