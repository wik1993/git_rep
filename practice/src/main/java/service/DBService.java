package service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class DBService {

    private Session session;

    private static DBService dbservice = new DBService();

    private DBService() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    public static DBService getDbservice() {
        return dbservice;
    }

    public Session getSession() {
        return session;
    }

    /* Method to SAVE in the database */
    public void save(Object obj) {
        Transaction tx = session.beginTransaction();
        session.save(obj);
        tx.commit();
    }

    /* Method to Read's by ID and Object type in the database */
        public List read(CriteriaQuery criteria) {
        return session.createQuery(criteria).getResultList();
    }

    public void update(Object object) {
        Transaction tx = null;
        tx = session.beginTransaction();
        session.update(object);
        tx.commit();
    }

    public void delete(Object object) {
        Transaction tx = null;
        tx = session.beginTransaction();
        session.delete(object);
        tx.commit();
    }

    public  CriteriaBuilder getCB(DBService dbService) {
        return dbService.getSession().getCriteriaBuilder();
    }

    public CriteriaQuery getCriteriaQuery(Class<?> objectType){
        CriteriaBuilder criteriaBuilder = getCB(dbservice);
        return criteriaBuilder.createQuery(objectType);
    }
}
