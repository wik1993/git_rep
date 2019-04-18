package internship.repository;

import internship.model.Mark;
import internship.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MarkRepository extends CrudRepository<Mark, Integer> {
    List<Mark> findAll();
    List<Mark> findAllByStudent(Student student);
}
