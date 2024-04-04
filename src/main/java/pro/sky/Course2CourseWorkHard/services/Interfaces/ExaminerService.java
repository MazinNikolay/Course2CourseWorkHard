package pro.sky.Course2CourseWorkHard.services.Interfaces;

import pro.sky.Course2CourseWorkHard.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
