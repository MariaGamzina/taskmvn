package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void shouldMatchQuerySimpleTask() {
        Task task = new SimpleTask(11, "Чек-лист");

        boolean expected = true;
        boolean actual = task.matches("Чек-лист");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchQuerySimpleTaskWrong() {
        Task task = new SimpleTask(11, "Список");

        boolean expected = false;
        boolean actual = task.matches("Чек-лист");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchQueryEpic() {
        String[] subtasks = {"Чек-лист", "Баг-репорт", "Тестовая докуметация"};
        Task task = new Epic(117, subtasks);


        boolean expected = true;
        boolean actual = task.matches("Чек-лист");

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldMatchQueryEpicWrong() {
        String[] subtasks = {"Чек-лист", "Баг-репорт", "Тестовая докуметация"};
        Task task = new Epic(117, subtasks);


        boolean expected = false;
        boolean actual = task.matches("Список");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchQueryMeeting() {
        Task task = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        boolean expected = true;
        boolean actual = task.matches("Приложение");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchQueryMeetingWrong() {
        Task task = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        boolean expected = false;
        boolean actual = task.matches("Список");

        Assertions.assertEquals(expected, actual);
    }

}
