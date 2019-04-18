package internship.service;

import internship.model.University;
import internship.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepository universityRepository;


    @Override
    public void addUniversity(University university) {
        universityRepository.save(university);
    }

    @Override
    public void updateUniversity(Integer id, University university) {
      universityRepository.findById(id)
                .map(univ -> {
                    univ.setName(university.getName());
                    univ.setShortName(university.getShortName());
                    University updated = universityRepository.save(univ);
                    return ResponseEntity.ok().body(updated);
                });
    }

    @Override
    public List<University> findAllUniversities() {
        return universityRepository.findAll();
    }

    @Override
    public Optional<University> findUniversityById(Integer id) {
        return universityRepository.findById(id);
    }

    @Override
    public void deleteUniversity(Integer id) {
        universityRepository.deleteById(id);
    }

    @Override
    public List<University> findUniversityByShortName(String shortName) {
        return universityRepository.findAllByShortName(shortName);
    }
}
