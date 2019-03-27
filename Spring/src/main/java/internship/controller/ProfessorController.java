package internship.controller;


import internship.model.Professor;
import internship.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/profesor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<Professor> addProfessor(@RequestBody Professor professor) {
        try {
            professorRepository.save(professor);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
       return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Professor> updateProfessor(@PathVariable("id") Integer id, @RequestBody Professor professor) {
        professorRepository.findById(id)
                .map(prof -> {
                    prof.setFirstName(professor.getFirstName());
                    prof.setLastName(professor.getLastName());
                    Professor updated = professorRepository.save(prof);
                    return ResponseEntity.ok().body(updated);
                });
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Professor> findAllProfessors() {
        return professorRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Professor> findById(@PathVariable("id") Integer id) {
        return professorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Professor> deleteById(@PathVariable("id") Integer id) {
        try {
            professorRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
