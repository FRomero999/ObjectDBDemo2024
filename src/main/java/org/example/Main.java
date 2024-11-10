package org.example;

import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("data.odb");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        {
            User u = new User();
            u.setEmail("test@example.com");
            u.setPassword("passtest");
            u.setIsAdmin(false);
            em.persist(u);
        }
        em.getTransaction().commit();

        TypedQuery<User> q = em.createQuery("SELECT u FROM User u", User.class);
        q.getResultList().forEach(System.out::println);

    }
}