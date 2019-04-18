package internship.service;

import internship.model.Professor;

import java.util.List;
import java.util.Optional;

public interface ProfessorService {

    void addProfessor(Professor professor);

    void updateProfessor(Integer id, Professor professor);

    List<Professor> findAllProfessors();

    Optional<Professor> findProfessorById(Integer id);

    void deleteProfessor(Integer id);
}
