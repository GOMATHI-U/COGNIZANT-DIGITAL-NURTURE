package com.example;

import com.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {

    public static void main(String[] args) {

        // Load Hibernate configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // Create SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open Session
        Session session = sessionFactory.openSession();

        // Begin Transaction
        Transaction transaction = session.beginTransaction();

        // Create Student object
        Student student = new Student(1, "John", "Computer Science");

        // Save object
        session.persist(student);

        // Commit Transaction
        transaction.commit();

        // Close Session
        session.close();
        sessionFactory.close();

        System.out.println("Student saved successfully!");
    }
}