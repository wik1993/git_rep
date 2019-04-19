package internship.service;

import internship.model.Mark;
import internship.model.Student;
import internship.model.Subject;

import java.util.List;
import java.util.Optional;

public interface MarkService {

    void addMark(Mark mark);

    void updateMark(Integer id, Mark mark);

    List<Mark> findAllMarks();

    List<Mark> findAllMarksByStudent(Student student);

    List<Mark> findAllMarksByStudentAndSubject(Student student, Subject subject);

    Optional<Mark> findMarkById(Integer id);

    void deleteMark(Integer id);
}
