package internship.controller;

import internship.model.Mark;
import internship.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/mark")
public class MarkController {

    @Autowired
    private MarkService markService;

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
    Iterable<Mark> findAllMarks() {
        return markService.findAllMarks();
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
