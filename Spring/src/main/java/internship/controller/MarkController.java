package internship.controller;

import internship.model.Mark;
import internship.model.Student;
import internship.service.MarkService;
import internship.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(path = "/mark")
public class MarkController {

    @Autowired
    private MarkService markService;

    @Autowired
    private StudentService studentService;

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity addmark(@RequestBody Mark mark) {
        try {
            markService.addMark(mark);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Mark> updateMark(@PathVariable("id") Integer id, @RequestBody Mark mark) {
        try {
            markService.updateMark(id, mark);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    ResponseEntity<List<Mark>> findAllMarks() {
        List<Mark> list;
        try{
            list = markService.findAllMarks();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }

    /*@GetMapping(path = "/all/{id}")
    public @ResponseBody
    ResponseEntity findAllMarksByCustomer(@PathVariable("id") Integer id) {
        List<Mark> list;
        Student student;
        List <Integer> marks;
        try{
            student = studentService.findStudentById(id).orElse(null);
            list = markService.findAllMarksByStudent(student);
            marks = new ArrayList<>();
            for (Mark mark: list) {
                marks.add(mark.getValue());
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(marks);
    }*/

    @GetMapping(path = "/all/{id}")
    public @ResponseBody
    ResponseEntity findAllMarksByCustomer(@PathVariable("id") Integer id) {
        List<Mark> list;
        Student student;
        List <Integer> marks;
        try{
            student = studentService.findStudentById(id).orElse(null);
            list = markService.findAllMarksByStudent(student);
            marks = new ArrayList<>();
            for (Mark mark: list) {
                marks.add(mark.getValue());
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(marks);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Mark> findById(@PathVariable("id") Integer id) {
        return markService.findMarkById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity deleteById(@PathVariable("id") Integer id) {
        try {
            markService.deleteMark(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}
