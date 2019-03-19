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
    public Session getSession() {
        return session;
    }

    private Session session;

    public DBService(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    /* Method to SAVE in the database */
    public void save(Object obj) {
        session.save(obj);
    }

    /* Method to Read's by ID and Object type in the database */
    public Object read(CriteriaQuery criteria) {
        return session.createQuery(criteria).getSingleResult();

    }


    public void update(Object object) {
        session.update(object);
    }

    public void delete(Object object) {
        session.delete(object);
    }

}
