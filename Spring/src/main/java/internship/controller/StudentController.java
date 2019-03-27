package internship.controller;


import internship.model.Student;
import internship.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<Student> addStudent(@RequestBody Student student) {
        try {
            studentRepository.save(student);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Student> udpateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
        studentRepository.findById(id)
                .map(stud -> {
                    stud.setFirstName(student.getFirstName());
                    stud.setLastName(student.getLastName());
                    Student updated = studentRepository.save(stud);
                    return ResponseEntity.ok().body(updated);
                });
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Student> findById(@PathVariable("id") Integer id) {
        return studentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Student> deleteById(@PathVariable("id") Integer id) {
        try {
            studentRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}
