package internship.service;

import internship.model.Mark;
import internship.model.Student;
import internship.model.Subject;
import internship.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkServiceImpl implements MarkService {

    @Autowired
    private MarkRepository markRepository;

    @Override
    public void addMark(Mark mark) {
        markRepository.save(mark);
    }

    @Override
    public void updateMark(Integer id, Mark mark) {
        markRepository.findById(id)
                .map(m -> {
                    m.setValue(mark.getValue());
                    Mark updated = markRepository.save(m);
                    return ResponseEntity.ok().body(updated);
                });
    }

    @Override
    public List<Mark> findAllMarks() {
        return markRepository.findAll();
    }


    @Override
    public List<Mark> findAllMarksByStudentAndSubject(Student student, Subject subject) {
        return markRepository.findAllByStudentAndSubject(student, subject);
    }

    @Override
    public Optional<Mark> findMarkById(Integer id) {
        return markRepository.findById(id);
    }

    @Override
    public void deleteMark(Integer id) {
        markRepository.deleteById(id);
    }
}
