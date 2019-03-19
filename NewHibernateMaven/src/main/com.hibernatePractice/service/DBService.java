package service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public class DBService {
    private static Session session;
    public SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
    public Session getSession() {
        return session;
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

    public void read(Query query) {
        List results = query.getResultList();
        results.forEach(x -> System.out.println(results));
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
