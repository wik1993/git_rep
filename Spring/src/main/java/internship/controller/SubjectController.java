package internship.controller;

import internship.model.Subject;
import internship.repository.SubjectRepository;
import internship.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
        try {
            subjectService.addSubject(subject);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Subject> updateSubject(@PathVariable("id") Integer id, @RequestBody Subject subject) {
        try{subjectService.updateSubject(id, subject);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Subject> findAllSubjects() {
        return subjectService.findAllSubjects();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Subject> findById(@PathVariable("id") Integer id) {
        return subjectService.findSubjectById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Subject> deleteById(@PathVariable("id") Integer id) {
        try {
            subjectService.deleteSubject(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
