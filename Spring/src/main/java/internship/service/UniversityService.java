package internship.service;

import internship.model.University;

import java.util.List;
import java.util.Optional;

public interface UniversityService  {

    void addUniversity(University university);

    void updateUniversity(Integer id, University university);

    List<University> findAllUniversities();

    Optional<University> findUniversityById(Integer id);

    void deleteUniversity(Integer id);

    List<University> findUniversityByShortName(String shortName);
}
