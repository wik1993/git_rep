package service;
import models.Student;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


public class StudentService {
    private DBService service = DBService.getDbservice();

    public void addStudent(Student student){
        service.save(student);
    }

    public Student getStudentById(Integer id){
        return service.getSession().get(Student.class, id);
    }

    public List getStudentByFirstName(String firstName) {
        CriteriaBuilder criteriaBuilder = service.getCB(service);
        CriteriaQuery criteriaQuery = service.getCriteriaQuery(Student.class);
        Root stud = criteriaQuery.from(Student.class);
        Predicate cond = criteriaBuilder.equal(stud.get("firstName"), firstName);
        criteriaQuery.where(cond);
        List list = service.read(criteriaQuery);
        return list;
    }

    public List getAllStudents(){

        return service.getSession().createQuery("FROM Student").list();

    }

    public void updateStudent(Student student){
        service.update(student);
    }

    public void deleteStudent(Student student){
        service.delete(student);
    }
}
