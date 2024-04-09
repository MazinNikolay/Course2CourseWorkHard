package pro.sky.Course2CourseWorkHard.repisitory.interfaces;

import pro.sky.Course2CourseWorkHard.model.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
