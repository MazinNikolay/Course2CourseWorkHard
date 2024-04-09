package pro.sky.Course2CourseWorkHard.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Course2CourseWorkHard.model.Question;
import pro.sky.Course2CourseWorkHard.repisitory.interfaces.QuestionRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {
    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private MathQuestionService out;

    private Set<Question> questionSet;

    @BeforeEach
    public void initSet() {
        questionSet = new HashSet<>(Arrays.asList(new Question("Как еще называют периметр круга?",
                        "Окружность"),
                new Question("Что такое Пи, рациональное или иррациональное число?",
                        "Пи — иррациональное число."),
                new Question("Изображение, которое также можно увидеть в трех измерениях?",
                        "Голограмма")));
    }

    @Test
    void addWithStrnings() {
        //Подготовка входных данных
        String question = "На какие типы делятся переменные?";
        String answer = "Примитивные и ссылочные";

        //Подготовко ожидаемого результата
        Question questionExpected = new Question(question, answer);
        when(out.add(question, answer)).thenReturn(questionExpected);

        //Начало теста
        Question questionActual = out.add(questionExpected);
        assertEquals(questionExpected, questionActual);
        verify(questionRepository).add(any());
        verifyNoMoreInteractions(questionRepository);
    }

    @Test
    void addWithQuestion() {
        //Подготовка входных данных
        String question = "На какие типы делятся переменные?";
        String answer = "Примитивные и ссылочные";

        //Подготовко ожидаемого результата
        Question questionExpected = new Question(question, answer);
        when(questionRepository.add(any())).thenReturn(questionExpected);

        //Начало теста
        Question questionActual = out.add(question, answer);
        assertEquals(questionExpected, questionActual);
        verify(questionRepository).add(any());
        verifyNoMoreInteractions(questionRepository);
    }

    @Test
    void removeWithStrings() {
        //Подготовка входных данных
        String question = "На какие типы делятся переменные?";
        String answer = "Примитивные и ссылочные";
        questionSet.add(new Question(question, answer));

        //Подготовко ожидаемого результата
        Question questionExpected = new Question(question, answer);
        when(questionRepository.getAll()).thenReturn(questionSet);
        when(questionRepository.remove(any())).thenReturn(questionExpected);

        //Начало теста
        Question questionActual = out.remove(question, answer);
        assertEquals(questionExpected, questionActual);
        verify(questionRepository).remove(any());
        verifyNoMoreInteractions(questionRepository);
    }

    @Test
    void RemoveWithQuestion() {
        //Подготовка входных данных
        String question = "На какие типы делятся переменные?";
        String answer = "Примитивные и ссылочные";
        questionSet.add(new Question(question, answer));

        //Подготовко ожидаемого результата
        Question questionExpected = new Question(question, answer);
        when(questionRepository.getAll()).thenReturn(questionSet);
        when(questionRepository.remove(any())).thenReturn(questionExpected);

        //Начало теста
        Question questionActual = out.remove(questionExpected);
        assertEquals(questionExpected, questionActual);
        verify(questionRepository).remove(any());
        verifyNoMoreInteractions(questionRepository);
    }

    @Test
    void getAll() {
        //Подготовко ожидаемого результата
        when(questionRepository.getAll()).thenReturn(questionSet);

        //Начало теста
        Collection<Question> actual = out.getAll();
        assertEquals(questionSet, actual);
        verify(questionRepository).getAll();
        verifyNoMoreInteractions(questionRepository);
    }

    @Test
    void getRandomQuestion() {
        //Подготовко ожидаемого результата
        when(questionRepository.getAll()).thenReturn(questionSet);

        //Начало теста
        Question question = out.getRandomQuestion();
        assertTrue(questionSet.contains(question));
        verifyNoMoreInteractions(questionRepository);
    }
}