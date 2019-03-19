package test;

import models.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import service.DBService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        DBService service = new DBService();
        University university = new University();
        university.setId(1);
        university.setName("Academia de Patani");
        university.setShortName("AP");

        CriteriaBuilder criteriaBuilder = getCB(service);
        CriteriaQuery <Professor> criteriaQuery = criteriaBuilder.createQuery(Professor.class);
        Root<Professor> prof = criteriaQuery.from(Professor.class);
        Predicate cond = criteriaBuilder.equal(prof.get("id"),1);
        criteriaQuery.where(cond);
        Professor professor = (Professor) service.read(criteriaQuery);
        System.out.println(professor.toString());

    }

    private static CriteriaBuilder getCB(DBService dbService) {
        return dbService.getSession().getCriteriaBuilder();
    }
}
