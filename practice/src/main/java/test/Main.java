package test;

import service.*;

import java.util.List;


public class Main {

    static StudentService service  = new StudentService();
    public static void main(String[] args) {
        //DBService service = DBService.getDbService();
        List list = service.getAllStudents();

        list.forEach(x-> System.out.println(x));

        /*CriteriaQuery criteriaQuery = service.getCriteriaQuery(Professor.class);
        Root prof = criteriaQuery.from(Professor.class);
        Predicate cond = service.getCriteriaBuilder(service).equal(prof.get("id"), 1);
        criteriaQuery.where(cond);
        List list = (List) service.read(criteriaQuery);
        list.forEach(x-> System.out.println(x.toString()));*/

    }


}