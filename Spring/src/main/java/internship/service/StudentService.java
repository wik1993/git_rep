package internship.service;

import internship.model.Student;

import java.util.Optional;

public interface StudentService {

    void addStudent(Student student);

    void updateStudent(Integer id, Student student);

    Iterable<Student> findAllStudents();

    Optional<Student> findStudentById(Integer id);

    void deleteStudent(Integer id);


}
