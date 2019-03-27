package internship.controller;

import internship.model.Subject;
import internship.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/subject")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
        try {
            subjectRepository.save(subject);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Subject> updateSubject(@PathVariable("id") Integer id, @RequestBody Subject subject) {
        subjectRepository.findById(id)
                .map(sub -> {
                    sub.setName(subject.getName());
                    sub.setNumberHour(subject.getNumberHour());
                    Subject updated = subjectRepository.save(sub);
                    return ResponseEntity.ok().body(updated);
                });
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Subject> findAllSubjects() {
        return subjectRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Subject> findById(@PathVariable("id") Integer id) {
        return subjectRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Subject> deleteById(@PathVariable("id") Integer id) {
        try {
            subjectRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
