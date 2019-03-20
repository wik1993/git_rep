package service;
import models.Student;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


public class StudentService {
    private DBService service = DBService.getDbService();

    public void addStudent(Student student){
        service.save(student);
    }

    public Student getStudentById(Integer id){
        CriteriaBuilder criteriaBuilder = service.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = service.getCriteriaQuery(Student.class);
        Root stud = criteriaQuery.from(Student.class);
        Predicate cond = criteriaBuilder.equal(stud.get("id"), id);
        criteriaQuery.where(cond);
        List result = service.read(criteriaQuery);
        if (result.isEmpty()) {
            return null;
        } else {
            return (Student) result.get(0);
        }
    }

    public List<Student> getStudentByFirstName(String firstName) {
        CriteriaBuilder criteriaBuilder = service.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = service.getCriteriaQuery(Student.class);
        Root stud = criteriaQuery.from(Student.class);
        Predicate cond = criteriaBuilder.equal(stud.get("firstName"), firstName);
        criteriaQuery.where(cond);
        return service.read(criteriaQuery);
    }

    public List<Student> getAllStudents(){
        CriteriaQuery criteriaQuery = service.getCriteriaQuery(Student.class);
        Root stud = criteriaQuery.from(Student.class);
        criteriaQuery.select(stud);
        return service.read(criteriaQuery);
    }

    public void updateStudent(Student student){
        service.update(student);
    }

    public void deleteStudent(Student student){
        service.delete(student);
    }
}
