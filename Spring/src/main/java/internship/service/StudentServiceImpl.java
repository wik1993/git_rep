package internship.service;

import internship.model.Student;
import internship.model.University;
import internship.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Integer id, Student student) {
        studentRepository.findById(id)
                .map(stud -> {
                    stud.setFirstName(student.getFirstName());
                    stud.setLastName(student.getLastName());
                    Student  updated = studentRepository.save(stud);
                    return ResponseEntity.ok().body(updated);
                });
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
