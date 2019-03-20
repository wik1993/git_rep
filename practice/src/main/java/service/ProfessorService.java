package service;

import models.Professor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProfessorService {
    private DBService service = DBService.getDbService();

    public void addProfessor(Professor professor){
        service.save(professor);
    }

    public Professor getProfessorById(Integer id){
        CriteriaBuilder criteriaBuilder = service.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = service.getCriteriaQuery(Professor.class);
        Root prof = criteriaQuery.from(Professor.class);
        Predicate cond = criteriaBuilder.equal(prof.get("id"), id);
        criteriaQuery.where(cond);
        List result = service.read(criteriaQuery);
        if (result.isEmpty()) {
            return null;
        } else {
            return (Professor) result.get(0);
        }
    }

    public List getProfessorByFirstName(String firstName){
        CriteriaBuilder criteriaBuilder = service.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = service.getCriteriaQuery(Professor.class);
        Root prof = criteriaQuery.from(Professor.class);
        Predicate cond = criteriaBuilder.equal(prof.get("firstName"), firstName);
        criteriaQuery.where(cond);
        return service.read(criteriaQuery);
    }

    public List getAllProfessors(){
        CriteriaQuery criteriaQuery = service.getCriteriaQuery(Professor.class);
        Root prof = criteriaQuery.from(Professor.class);
        criteriaQuery.select(prof);
        return service.read(criteriaQuery);
    }
    public void updateProfessor(Professor professor) {
        service.update(professor);
    }

    public void deleteProfessor(Professor professor) {
        service.delete(professor);
    }
}
