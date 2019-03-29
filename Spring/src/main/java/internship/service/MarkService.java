package internship.service;

import internship.model.Mark;

import java.util.Optional;

public interface MarkService {

    void addMark(Mark mark);

    void updateMark(Integer id, Mark mark);

    Iterable<Mark> findAllMarks();

    Optional<Mark> findMarkById(Integer id);

    void deleteMark(Integer id);
}
