package internship.service;

import internship.model.Professor;

import java.util.Optional;

public interface ProfessorService {

    void addProfessor(Professor professor);

    void updateProfessor(Integer id, Professor professor);

    Iterable<Professor> findAllProfessors();

    Optional<Professor> findProfessorById(Integer id);

    void deleteProfessor(Integer id);
}
