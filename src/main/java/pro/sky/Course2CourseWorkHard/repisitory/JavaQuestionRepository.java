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
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    private void init() {
        questions.add(new Question("Что такое цикл?", "Конструкция кода, которая повторяет" +
                " одно и то же действие несколько (столько, сколько нам потребуется) раз"));
        questions.add(new Question("Что такое переменная?", "Это ячейка в памяти компьютера," +
                " которой можно присвоить имя и в которой можно хранить данные"));
        questions.add(new Question("Что такое инициализация?", "Присваивание какого-то значения" +
                " переменной"));
        questions.add(new Question("Дайте определение строке?", "Неизменяемый объект, который" +
                " хранит последовательность символов"));
        questions.add(new Question("Что такое коллекции?", "Общее название для нескольких структур" +
                " данных в Java"));
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
