package internship.service;

import internship.model.Subject;
import internship.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public void addSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public void updateSubject(Integer id, Subject subject) {
        subjectRepository.findById(id)
                .map(sub -> {
                    sub.setName(subject.getName());
                    sub.setNumberHour(subject.getNumberHour());
                    Subject updated = subjectRepository.save(sub);
                    return ResponseEntity.ok().body(updated);
                });
    }

    @Override
    public Iterable<Subject> findAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> findSubjectById(Integer id) {
        return subjectRepository.findById(id);
    }

    @Override
    public void deleteSubject(Integer id) {
        subjectRepository.deleteById(id);
    }
}
