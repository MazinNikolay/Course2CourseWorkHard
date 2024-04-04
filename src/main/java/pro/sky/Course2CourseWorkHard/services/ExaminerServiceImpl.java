package pro.sky.Course2CourseWorkHard.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.Course2CourseWorkHard.exceptions.IncorrectArgumentException;
import pro.sky.Course2CourseWorkHard.model.Question;
import pro.sky.Course2CourseWorkHard.services.Interfaces.ExaminerService;
import pro.sky.Course2CourseWorkHard.services.Interfaces.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        isCorrectAmount(amount);
        Set<Question> questionsList = new HashSet<>(javaQuestionService.getAll());
        questionsList.addAll(mathQuestionService.getAll());
        Set<Question> resultQuestions = new HashSet<>(amount);
        while (resultQuestions.size() < amount) {
            if (amount > 1 && resultQuestions.size() < amount - 1) {
                resultQuestions.add(javaQuestionService.getRandomQuestion());
                resultQuestions.add(mathQuestionService.getRandomQuestion());
            } else
                resultQuestions.add(javaQuestionService.getRandomQuestion());
        }
        return resultQuestions;
    }

    private void isCorrectAmount(int amount) {
        int totalSize = javaQuestionService.getAll().size() + mathQuestionService.getAll().size();
        if (amount > totalSize) {
            throw new IncorrectArgumentException("Количество запрашиваемых воросов превышет количество" +
                    " вопросов в базе");
        }
    }
}
