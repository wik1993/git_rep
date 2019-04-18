package internship.controller;

import internship.model.Professor;
import internship.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(path = "/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<Professor> addProfessor(@RequestBody Professor professor) {
        try {
            professorService.addProfessor(professor);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
       return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Professor> updateProfessor(@PathVariable("id") Integer id, @RequestBody Professor professor) {
        try {
            professorService.updateProfessor(id, professor);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    ResponseEntity<List<Professor>> findAllProfessors() {
        List<Professor> list;
        try{
           list = professorService.findAllProfessors();
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Professor> findById(@PathVariable("id") Integer id) {
        return professorService.findProfessorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Professor> deleteById(@PathVariable("id") Integer id) {
        try {
            professorService.deleteProfessor(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
