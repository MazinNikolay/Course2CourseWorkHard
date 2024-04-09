package pro.sky.Course2CourseWorkHard.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Course2CourseWorkHard.exceptions.IncorrectArgumentException;
import pro.sky.Course2CourseWorkHard.model.Question;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    @Mock
    private MathQuestionService mathQuestionService;

    @InjectMocks
    private ExaminerServiceImpl out;

    private Set<Question> mathQuestionSet;
    private Set<Question> javaQuestionSet;

    @BeforeEach
    public void initSet() {
        mathQuestionSet = new HashSet<>(Arrays.asList(new Question("Как еще называют периметр круга?",
                        "Окружность"),
                new Question("Что такое Пи, рациональное или иррациональное число?",
                        "Пи — иррациональное число."),
                new Question("Изображение, которое также можно увидеть в трех измерениях?",
                        "Голограмма")));
        javaQuestionSet = new HashSet<>(Arrays.asList(new Question("Что такое цикл?",
                        "Конструкция кода, которая повторяет одно и то же действие несколько " +
                                "столько, сколько нам потребуется) раз"),
                new Question("Что такое переменная?", "Это ячейка в памяти компьютера," +
                        " которой можно присвоить имя и в которой можно хранить данные"),
                new Question("Что такое инициализация?", "Присваивание какого-то значения" +
                        " переменной")));
    }

    @Test
    void getQuestionsWithIncorrectAmount() {
        //Подготовка входных данных

        //Подготовко ожидаемого результата

        //Начало теста
        assertThrows(IncorrectArgumentException.class, () -> out.getQuestions(9));
    }

    void getQuestions() {
        //Подготовка входных данных

        //Подготовко ожидаемого результата
        when(javaQuestionService.getAll()).thenReturn(javaQuestionSet);
        when(mathQuestionService.getAll()).thenReturn(mathQuestionSet);
        when(javaQuestionService.getRandomQuestion()).thenReturn(javaQuestionSet.iterator().next());
        when(mathQuestionService.getRandomQuestion()).thenReturn(mathQuestionSet.iterator().next());
        Collection<Question> result = out.getQuestions(6);

        //Начало теста
        assertTrue(result.containsAll(javaQuestionSet) && result.containsAll(mathQuestionSet));
        verify(javaQuestionService).getRandomQuestion();
        verify(mathQuestionService).getRandomQuestion();
    }
}