package pro.sky.Course2CourseWorkHard.repisitory;

import org.springframework.stereotype.Repository;
import pro.sky.Course2CourseWorkHard.model.Question;
import pro.sky.Course2CourseWorkHard.repisitory.interfaces.QuestionRepository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {

    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    private void init() {
        questions.add(new Question("Как еще называют периметр круга?", "Окружность"));
        questions.add(new Question("Что такое Пи, рациональное или иррациональное число?",
                "Пи — иррациональное число."));
        questions.add(new Question("Изображение, которое также можно увидеть в трех измерениях?",
                "Голограмма"));
        questions.add(new Question("Кто изобрел знак равенства '='?", "Роберт Рекорд"));
        questions.add(new Question("Кто является отцом математики?", "Архимед"));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }
}
