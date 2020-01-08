package ru.kuper.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "students")
public class Student {
    @Id @GeneratedValue
    int id;
    private String name;

    @ElementCollection(fetch = FetchType.LAZY)
            @CollectionTable(name = "ListOfStudentMarks")
            @Column(name = "mark")
    List<String> list = new ArrayList<>();


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "mapStudent")
    @Column(name = "mapa")
            @MapKeyColumn(name = "myKey")
    Map<Integer, String> map = new HashMap();

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    byte[] img;

    public Student(String name, Date birth) {
        this.name = name;
        gender = Gender.MALE;
        list.add("one");
        list.add("two");
        list.add("three");

        map.put(1,"one");
        map.put(2,"two");

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
