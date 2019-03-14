package com.jcg.hibernate.maven;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class AppMain {

    private static SessionFactory factory;

    public static void main(String[] args) {

        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        AppMain AM = new AppMain();

        /* Add few child records in database */
        //AM.addChild(6, "Zara", "Ali", 69);

        /* List down all the children */
         AM.listChildren();

        /* Update child's records */
        // AM.updateChild(4,33);

        //Delete an child from the database */
         //AM.deleteChild(6);

        /* List down new list of the children */
       // AM.listChildren();
    }

    /* Method to CREATE an child in the database */
    public Integer addChild(int id, String firstName, String lastName, int age) {
        Session session = factory.openSession();
        Transaction tx;
        Integer childID;

        tx = session.beginTransaction();
        Child child = new Child(id, firstName, lastName, age);
        childID = (Integer) session.save(child);
        tx.commit();
        session.close();

        return childID;
    }

    /* Method to  READ all the children */
    private void listChildren() {
        Session session = factory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        List children = session.createQuery("FROM Child").list();
        for (Object child1 : children) {
            Child child = (Child) child1;
            System.out.println("ID: " + child.getId());
            System.out.print("First Name: " + child.getFirstName());
            System.out.print("  Last Name: " + child.getLastName());
            System.out.println("  Age: " + child.getAge());
        }
        tx.commit();
        session.close();
    }

    /* Method to UPDATE age for an child */
    public void updateChild(Integer ChildID, int age) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Child child = session.get(Child.class, ChildID);
            child.setAge(age);
            session.update(child);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an child from the records */
    public void deleteChild(Integer ChildID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Child child = session.get(Child.class, ChildID);
            session.delete(child);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}