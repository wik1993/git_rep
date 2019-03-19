package test;

import models.*;

import org.hibernate.Session;
import org.hibernate.query.Query;
import service.DBService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class Main {
    private static CriteriaBuilder getCB(DBService dbService) {
        return dbService.getSession().getCriteriaBuilder();
    }

   public static Session getSession() {
        DBService dbService = new DBService();
        return dbService.getSessionFactory().openSession();

    }

    public static void main(String[] args) {
        DBService service = new DBService();
        University university = new University();
        university.setId(1);
        university.setName("Academia de Patani");
        university.setShortName("AP");

        //service.update(university);
        //Criteria criteria = getSession().createCriteria(Professor.class).add(Restrictions.eq("id", 1));
        CriteriaQuery <Professor> criteriaQuery = getCB(service).createQuery(Professor.class);
        Root<Professor> root = criteriaQuery.from(Professor.class);
        criteriaQuery.select(root).where(getCB(service).equal(root.get("id"), 1));
        Query<Professor> query = getSession().createQuery(criteriaQuery);
        service.read(query);
    }
}
