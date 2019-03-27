package internship.controller;

import internship.model.Mark;
import internship.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/mark")
public class MarkController {

    @Autowired
    private MarkRepository markRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity addmark(@RequestBody Mark mark) {
        try {
            markRepository.save(mark);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Mark> updateMark(@PathVariable("id") Integer id, @RequestBody Mark mark) {
        markRepository.findById(id)
                .map(m -> {
                    m.setValue(mark.getValue());
                    Mark updated = markRepository.save(m);
                    return ResponseEntity.ok().body(updated);
                });
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Mark> findAllMarks() {
        return markRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Mark> findById(@PathVariable("id") Integer id) {
        return markRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity deleteById(@PathVariable("id") Integer id) {
        try {
            markRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}
