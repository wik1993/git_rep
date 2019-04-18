package internship.controller;

import internship.model.University;
import internship.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/univer")
public class UniversityContoller {

    @Autowired
    private UniversityService universityService;

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<University> addUniversity(@RequestBody University university) {
        try {
            universityService.addUniversity(university);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<University> updateUniversity(@PathVariable("id") Integer id, @RequestBody University university) {
        try {
            universityService.updateUniversity(id, university);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    ResponseEntity<List<University>> findAllUniversities() {
        List<University> list;
        try{
           list = universityService.findAllUniversities();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<University> findById(@PathVariable("id") Integer id) {
        return universityService.findUniversityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<University> deleteUniversity(@PathVariable("id") Integer id) {
        try {
            universityService.deleteUniversity(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/short/{shortName}")
    public @ResponseBody
    ResponseEntity<University> findUniverbyShortName(@PathVariable("shortName") String university) {
        try{
            universityService.findUniversityByShortName(university);
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}
