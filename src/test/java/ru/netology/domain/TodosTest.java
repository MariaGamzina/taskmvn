package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchQueryInTodosOne() {
        SimpleTask simpleTask = new SimpleTask(8, "Позвонить родителям");


        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(56, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение НетоБанка");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldMatchQueryInTodosFew() {
        SimpleTask simpleTask1 = new SimpleTask(8, "Подготовить приложения");
        SimpleTask simpleTask2 = new SimpleTask(9, "Позвонить родителям");


        String[] subtasks1 = {"Молоко", "Яйца", "Хлеб"};
        Epic epic1 = new Epic(56, subtasks1);

        String[] subtasks2 = {"Новые приложения", "Чек-лист", "Баг-репорт"};
        Epic epic2 = new Epic(56, subtasks2);


        Meeting meeting1 = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Meeting meeting2 = new Meeting(
                666,
                "Выкатка 5й версии приложения",
                "Приложение Банка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic1);
        todos.add(epic2);
        todos.add(meeting1);
        todos.add(meeting2);


        Task[] expected = {simpleTask1, epic2, meeting1, meeting2};
        Task[] actual = todos.search("приложения");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldMatchQueryInTodosNoOne() {
        SimpleTask simpleTask = new SimpleTask(8, "Позвонить родителям");


        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(56, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {};
        Task[] actual = todos.search("картофель");
        Assertions.assertArrayEquals(expected, actual);

    }


}
