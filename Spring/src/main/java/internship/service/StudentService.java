package internship.service;

import internship.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    void addStudent(Student student);

    void updateStudent(Integer id, Student student);

    List<Student> findAllStudents();

    Optional<Student> findStudentById(Integer id);

    void deleteStudent(Integer id);


}
