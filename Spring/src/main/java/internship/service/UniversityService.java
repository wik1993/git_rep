package internship.service;

import internship.model.University;

import java.util.Optional;

public interface UniversityService  {

    void addUniversity(University university);

    void updateUniversity(Integer id, University university);

    Iterable<University> findAllUniversities();

    Optional<University> findUniversityById(Integer id);

    void deleteUniversity(Integer id);

    Iterable<University> findUniversityByShortName(String shortName);
}
