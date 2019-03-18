package test;

import models.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import service.DBService;


public class Main {
    public static Session getSession (){
        DBService dbService = new DBService();
        return dbService.getSessionFactory().openSession();

    }

    public static void main(String[] args) {
        DBService service = new DBService();
        University university = new University();
        university.setId(1);
        university.setName("Academia de Pidari");
        university.setShortName("AP");


        //service.update(university);
        Criteria criteria = getSession().createCriteria(Professor.class).add(Restrictions.eq("id", 1));
        service.read(criteria);
    }
}
