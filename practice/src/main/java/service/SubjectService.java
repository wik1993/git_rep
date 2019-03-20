package service;

import models.Subject;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class SubjectService {
    private DBService service = DBService.getDbService();

    public void addSubject (Subject subject){
        service.save(subject);
    }

    public Subject getSubjectById(Integer id){
        CriteriaBuilder criteriaBuilder = service.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = service.getCriteriaQuery(Subject.class);
        Root subj = criteriaQuery.from(Subject.class);
        Predicate cond = criteriaBuilder.equal(subj.get("id"), id);
        criteriaQuery.where(cond);
        List result = service.read(criteriaQuery);
        if (result.isEmpty()) {
            return null;
        } else {
            return (Subject) result.get(0);
        }
    }

    public List getSubjectByName(String subjectName){
        CriteriaBuilder criteriaBuilder = service.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = service.getCriteriaQuery(Subject.class);
        Root subj = criteriaQuery.from(Subject.class);
        Predicate cond = criteriaBuilder.equal(subj.get("name"), subjectName);
        criteriaQuery.where(cond);
        return service.read(criteriaQuery);
    }

    public List getAllSubjects(){
        CriteriaQuery criteriaQuery = service.getCriteriaQuery(Subject.class);
        Root subj = criteriaQuery.from(Subject.class);
        criteriaQuery.select(subj);
        return service.read(criteriaQuery);
    }

    public void updateSubject(Subject subject){
        service.update(subject);
    }

    public void deleteSubject(Subject subject){
        service.delete(subject);
    }
}
