package pro.sky.Course2CourseWorkHard.repisitory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.Course2CourseWorkHard.model.Question;
import pro.sky.Course2CourseWorkHard.repisitory.interfaces.QuestionRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionRepositoryTest {

    private QuestionRepository out;

    @BeforeEach
    public void initVariable() {
        out = new MathQuestionRepository();
    }

    @Test
    void addCorrect() {
        //Подготовка входных данных
        String question = "На какие типы делятся переменные?";
        String answer = "Примитивные и ссылочные";

        //Подготовка ожидаемого результата
        Question expected = new Question(question, answer);

        //Начало теста
        assertEquals(expected, out.add(expected));
    }

    @Test
    void remove() {
        //Подготовка входных данных
        String question = "На какие типы делятся переменные?";
        String answer = "Примитивные и ссылочные";

        //Подготовка ожидаемого результата
        Question expected = new Question(question, answer);
        out.add(expected);

        //Начало теста
        assertEquals(expected, out.remove(expected));
    }

    @Test
    void getAll() {
        //Подготовка входных данных
        String question1 = "На какие типы делятся переменные?";
        String answer1 = "Примитивные и ссылочные";
        String question2 = "Что такое цикл?";
        String answer2 = "Конструкция кода, которая повторяет одно и то же действие несколько " +
                "столько, сколько нам потребуется) раз";
        String question3 = "Что такое переменная?";
        String answer3 = "Это ячейка в памяти компьютера," +
                " которой можно присвоить имя и в которой можно хранить данные";
        Question q1 = new Question(question1, answer1);
        Question q2 = new Question(question2, answer2);
        Question q3 = new Question(question3, answer3);

        //Подготовка ожидаемого результата
        Collection<Question> expected = new HashSet<>(Arrays.asList(q1, q2, q3));
        out.add(q1);
        out.add(q2);
        out.add(q3);

        //Начало теста
        assertTrue(out.getAll().containsAll(expected));
        assertEquals(expected, out.getAll());
    }
}