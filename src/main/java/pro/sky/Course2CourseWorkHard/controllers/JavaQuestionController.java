package pro.sky.Course2CourseWorkHard.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.Course2CourseWorkHard.exceptions.IncorrectArgumentException;
import pro.sky.Course2CourseWorkHard.exceptions.NotFoundException;
import pro.sky.Course2CourseWorkHard.model.Question;
import pro.sky.Course2CourseWorkHard.services.Interfaces.QuestionService;

import java.util.Collection;


@RestController
@RequestMapping(path = "/java")
public class JavaQuestionController {
    private final QuestionService service;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService service) {
        this.service = service;
    }

    @ExceptionHandler(IncorrectArgumentException.class)
    public ResponseEntity<String> incorrectArgumentHandle(IncorrectArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> notFoundHandle(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam(value = "question", required = false) String question,
                                @RequestParam(value = "answer", required = false) String answer) {
        return service.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam(value = "question", required = false) String question,
                                   @RequestParam(value = "answer", required = false) String answer) {
        return service.remove(question, answer);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return service.getAll();
    }
}
