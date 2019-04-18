package internship.service;

import internship.model.Professor;
import internship.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public void addProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    @Override
    public void updateProfessor(Integer id, Professor professor) {
        professorRepository.findById(id)
                .map(prof -> {
                    prof.setFirstName(professor.getFirstName());
                    prof.setLastName(professor.getLastName());
                    Professor updated = professorRepository.save(prof);
                    return ResponseEntity.ok().body(updated);
                });

    }

    @Override
    public List<Professor> findAllProfessors() {
        return professorRepository.findAll();
    }

    @Override
    public Optional<Professor> findProfessorById(Integer id) {
        return professorRepository.findById(id);
    }

    @Override
    public void deleteProfessor(Integer id) {
        professorRepository.deleteById(id);
    }
}
