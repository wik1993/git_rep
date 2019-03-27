package internship.repository;

import internship.model.University;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UniversityRepository extends CrudRepository<University, Integer> {
        Iterable<University> findAllByShortName(String shortName);
}
