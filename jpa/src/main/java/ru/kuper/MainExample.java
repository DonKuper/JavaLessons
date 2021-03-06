package ru.kuper;

import ru.kuper.entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class MainExample {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
        EntityManager em = emf.createEntityManager();

        Student student = new Student("Max", new Date());
        Student student2 = new Student( "Paul", new Date());
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(student);
        em.persist(student2);
        tx.commit();
        em.close();
        emf.close();
    }
}
