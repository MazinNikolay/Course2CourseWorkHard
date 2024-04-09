package pro.sky.Course2CourseWorkHard.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.Course2CourseWorkHard.exceptions.IncorrectArgumentException;
import pro.sky.Course2CourseWorkHard.model.Question;
import pro.sky.Course2CourseWorkHard.services.Interfaces.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/get")
public class ExamController {
    private final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }

    @ExceptionHandler(IncorrectArgumentException.class)
    public ResponseEntity<String> incorrectArgumentHandle(IncorrectArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @GetMapping(path = "{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return service.getQuestions(amount);
    }
}
