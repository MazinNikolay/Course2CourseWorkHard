package pro.sky.Course2CourseWorkHard.services.Interfaces;

import pro.sky.Course2CourseWorkHard.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Question remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
