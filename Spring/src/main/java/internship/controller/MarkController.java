package internship.controller;

import internship.model.Mark;
import internship.model.Student;
import internship.model.Subject;
import internship.service.MailSchedulerService;
import internship.service.MarkService;
import internship.service.StudentService;
import internship.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/mark")
public class MarkController {

    @Autowired
    private MarkService markService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private MailSchedulerService mailSchedulerService;

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


    @GetMapping(path = "/avg")
    public @ResponseBody
    ResponseEntity findAllMarksBySubject() {
        Double avg;
        Map <Student, Map <Subject ,Double>> studentSubjectMap = new HashMap<>();
        try{
            for (Student stud: studentService.findAllStudents()) {
                Map <Subject, Double> subjectDoubleMap = new HashMap<>();
                for (Subject sub: subjectService.findAllSubjects()) {
                    avg = markService.findAllMarksByStudentAndSubject(stud, sub).stream().collect(Collectors.averagingInt(Mark::getValue));
                    subjectDoubleMap.put(sub, avg);
                    if (avg > 5.0){
                        mailSchedulerService.report();
                    }
                }
                studentSubjectMap.put(stud, subjectDoubleMap);
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentSubjectMap);
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
