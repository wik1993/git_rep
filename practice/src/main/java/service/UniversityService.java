package service;

import models.University;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UniversityService {
    private DBService service = DBService.getDbService();

    public void addUniversity(University university){
        service.save(university);
    }

    public University getUniversityById(Integer id){
        CriteriaBuilder criteriaBuilder = service.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = service.getCriteriaQuery(University.class);
        Root univer = criteriaQuery.from(University.class);
        Predicate cond = criteriaBuilder.equal(univer.get("id"), id);
        criteriaQuery.where(cond);
        List result = service.read(criteriaQuery);
        if (result.isEmpty()) {
            return null;
        } else {
            return (University) result.get(0);
        }
    }

    public List getUniversityByShortName(String shortName){
        CriteriaBuilder criteriaBuilder = service.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = service.getCriteriaQuery(University.class);
        Root stud = criteriaQuery.from(University.class);
        Predicate cond = criteriaBuilder.equal(stud.get("shortName"), shortName);
        criteriaQuery.where(cond);
        return service.read(criteriaQuery);
    }

    public List getAllUniveristies(){
        CriteriaQuery criteriaQuery = service.getCriteriaQuery(University.class);
        Root univ = criteriaQuery.from(University.class);
        criteriaQuery.select(univ);
        return service.read(criteriaQuery);
    }

    public void updateUniversity (University university){
        service.update(university);
    }

    public void deleteUniversity (University university){
        service.delete(university);
    }

}
