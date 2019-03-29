package internship.service;

import internship.model.Subject;

import java.util.Optional;

public interface SubjectService {
    void addSubject(Subject subject);

    void updateSubject(Integer id, Subject subject);

    Iterable<Subject> findAllSubjects();

    Optional<Subject> findSubjectById(Integer id);

    void deleteSubject(Integer id);
}
