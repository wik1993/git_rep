package internship.service;

import internship.model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    void addSubject(Subject subject);

    void updateSubject(Integer id, Subject subject);

    List<Subject> findAllSubjects();

    Optional<Subject> findSubjectById(Integer id);

    void deleteSubject(Integer id);
}
