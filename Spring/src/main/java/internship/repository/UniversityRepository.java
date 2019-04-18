package internship.repository;

import internship.model.University;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UniversityRepository extends CrudRepository<University, Integer> {
        List<University> findAllByShortName(String shortName);
        List<University> findAll();
}
