package internship.controller;


import internship.model.Student;
import internship.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<Student> addStudent(@RequestBody Student student) {
        try {
            studentService.addStudent(student);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Student> udpateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
        try{
            studentService.updateStudent(id, student);
        }catch (Exception e){
            e.printStackTrace();
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    ResponseEntity<List<Student>> findAllStudents() {
        List<Student> list;
        try{
          list = studentService.findAllStudents();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Student> findById(@PathVariable("id") Integer id) {
        return studentService.findStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Student> deleteById(@PathVariable("id") Integer id) {
        try {
            studentService.deleteStudent(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}
