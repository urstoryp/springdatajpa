package com.example.springdatajpa;

import com.example.springdatajpa.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory; // javax.persistence : JPA API
import javax.persistence.EntityTransaction;

@SpringBootApplication
public class SpringdatajpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringdatajpaApplication.class, args);
    }

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public void run(String... args) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            // JPA 관련된 코드.
//            User user = new User();
//            user.setName("김성박");
//            user.setEmail("urstory@gmail.com");
//            user.setPassword("1234");
//
//            entityManager.persist(user);

            User user = entityManager.find(User.class, 1);
            System.out.println(user);

            transaction.commit();
        }catch (Exception ex){
            transaction.rollback();
        }finally {
            entityManager.close();
        }
    }
}
