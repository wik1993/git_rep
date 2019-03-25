package internship.controller;

import internship.model.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import internship.service.UniversityRepository;

import java.util.Optional;

@Controller
@RequestMapping(path = "/univer")
public class UniversityContoller {
    @Autowired
    private UniversityRepository universityRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addUniversity(@RequestBody University university) {
        universityRepository.save(university);
        return "Save";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<University> findAllUniversities() {
        return universityRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    Optional<University> findById(@PathVariable("id") Integer id) {
        return universityRepository.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody
    String deleteUniversity(@PathVariable("id") Integer id) {
        universityRepository.deleteById(id);
        return "Deleted";
    }
}
