package pro.sky.Course2CourseWorkHard.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.Course2CourseWorkHard.exceptions.IncorrectArgumentException;
import pro.sky.Course2CourseWorkHard.exceptions.NotFoundException;
import pro.sky.Course2CourseWorkHard.model.Question;
import pro.sky.Course2CourseWorkHard.repisitory.interfaces.QuestionRepository;
import pro.sky.Course2CourseWorkHard.services.Interfaces.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private final QuestionRepository repository;

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        isCorrectArg(question, answer);
        Question newQuestion = new Question(question, answer);
        return repository.add(newQuestion);
    }

    @Override
    public Question add(Question question) {
        return repository.add(question);
    }

    @Override
    public Question remove(Question question) {
        isFound(question);
        return repository.remove(question);
    }

    @Override
    public Question remove(String question, String answer) {
        isCorrectArg(question, answer);
        Question newQuestion = new Question(question, answer);
        isFound(newQuestion);
        return repository.remove(newQuestion);
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random rnd = new Random();
        int rndValue = rnd.nextInt(repository.getAll().size());
        return new ArrayList<Question>(repository.getAll()).get(rndValue);
    }

    private void isCorrectArg(String arg1, String arg2) {
        boolean isNull = arg1 == null || arg2 == null;
        boolean isEmpty = false;
        if (!isNull) {
            isEmpty = arg1.isEmpty() || arg2.isEmpty();
        }
        if (isNull || isEmpty) {
            throw new IncorrectArgumentException("Некорректновведены аргументы. Пустые или отсутствуют");
        }
    }

    private void isFound(Question question) {
        if (!repository.getAll().contains(question)) {
            throw new NotFoundException("Указанный вопрос отсутвтует");
        }
    }
}
