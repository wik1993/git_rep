package service;

import models.Mark;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class MarkService {
    private DBService service = DBService.getDbService();

    public void addMark(Mark mark){
        service.save(mark);
    }

    public Mark getMarksById(Integer id){
        CriteriaBuilder criteriaBuilder = service.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = service.getCriteriaQuery(Mark.class);
        Root mark = criteriaQuery.from(Mark.class);
        Predicate cond = criteriaBuilder.equal(mark.get("id"), id);
        criteriaQuery.where(cond);
        List result = service.read(criteriaQuery);
        if (result.isEmpty()) {
            return null;
        } else {
            return (Mark) result.get(0);
        }
    }

    public List<Mark> getMarksByValue(Integer id){
        CriteriaBuilder criteriaBuilder = service.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = service.getCriteriaQuery(Mark.class);
        Root mark = criteriaQuery.from(Mark.class);
        Predicate cond = criteriaBuilder.equal(mark.get("value"), id);
        criteriaQuery.where(cond);
        return service.read(criteriaQuery);
    }

    public List<Mark> getAllMarks(){
        CriteriaQuery criteriaQuery = service.getCriteriaQuery(Mark.class);
        Root mark = criteriaQuery.from(Mark.class);
        criteriaQuery.select(mark);
        return service.read(criteriaQuery);
    }

    public void updateMark(Mark mark) {
        service.update(mark);
    }

    public void deleteMark (Mark mark) {
        service.delete(mark);
    }
}
