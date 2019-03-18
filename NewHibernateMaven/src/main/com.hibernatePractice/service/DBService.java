package service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.List;


public class DBService {

    public SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    /* Method to SAVE in the database */
    public void save(Object obj) {
        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(obj);
        tx.commit();
        session.close();

    }

    /* Method to Read's by ID and Object type in the database */

    public void read(Criteria criteria) {
        List result = criteria.list();
        result.forEach(System.out::println);
    }

       public void read(Integer id, Class<?> objectType) {
        Session session = getSessionFactory().openSession();
        Object result = session.get(objectType, id);
        System.out.println(result.toString());
        session.close();
    }


    public void update(Object object) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        tx = session.beginTransaction();
        session.update(object);
        tx.commit();
        session.close();
    }

    public void delete(Object object) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        tx = session.beginTransaction();
        session.delete(object);
        tx.commit();
        session.close();
    }

}
