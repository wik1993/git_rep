package test;

import models.Professor;
import models.Student;
import models.University;
import service.DBService;
import service.StudentService;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


public class Main {


    public static void main(String[] args) {
        DBService service = DBService.getDbservice();
        University university = new University();
        university.setId(1);
        university.setName("Huli Lucreaza");
        university.setShortName("AP");


        StudentService studentService = new StudentService();
        Student student = new Student();
        student.setId(101);
        student.setFirstName("Oleg");
        student.setLastName("Coarja");

        //studentService.addStudent(student);
        //System.out.println(studentService.getStudentById(103));
        //studentService.updateStudent(student);
        //studentService.deleteStudent(student);
        List list = studentService.getStudentByFirstName("Oleg");
        list.forEach(x-> System.out.println(x.toString()));



        /*CriteriaQuery criteriaQuery = service.getCriteriaQuery(Professor.class);
        Root prof = criteriaQuery.from(Professor.class);
        Predicate cond = service.getCB(service).equal(prof.get("id"), 1);
        criteriaQuery.where(cond);
        List list = (List) service.read(criteriaQuery);
        list.forEach(x-> System.out.println(x.toString()));*/

    }


}