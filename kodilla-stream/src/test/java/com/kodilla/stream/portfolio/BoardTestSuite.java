package com.kodilla.stream.portfolio;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class BoardTestSuite {
    private static TestBoardHelper testBoardHelper;

    @BeforeClass
    public static void createBoardBeforeAllTests(){
        testBoardHelper = new TestBoardHelper();
    }

    @Test
    public void testAddTaskList() {
        //Given
        Board project = testBoardHelper.prepareTestData();
        //When

        //Then
        Assert.assertEquals(3, project.getTaskLists().size());
    }

    @Test
    public void testAddTaskListFindUsersTasks() {
        //Given
        Board project = testBoardHelper.prepareTestData();
        //When
        User user = new User("developer1", "John Smith");
        List<Task> tasks = project.getTaskLists().stream()
                .flatMap(l -> l.getTasks().stream())
                .filter(t -> t.getAssignedUser().equals(user))
                .collect(toList());
        //Then
        Assert.assertEquals(2, tasks.size());
        Assert.assertEquals(user, tasks.get(0).getAssignedUser());
        Assert.assertEquals(user, tasks.get(1).getAssignedUser());
    }

    @Test
    public void testAddTaskListFindOutdatedTasks() {
        //Given
        Board project = testBoardHelper.prepareTestData();

        //When
        List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("To do"));
        undoneTasks.add(new TaskList("In progress"));
        List<Task> tasks = project.getTaskLists().stream()
                .filter(undoneTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .filter(t -> t.getDeadline().isBefore(LocalDate.now()))
                .collect(toList());

        //Then
        Assert.assertEquals(1, tasks.size());
        Assert.assertEquals("HQLs for analysis", tasks.get(0).getTitle());
    }

    @Test
    public void testAddTaskListFindLongTasks() {
        //Given
        Board project = testBoardHelper.prepareTestData();

        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        long longTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .map(t -> t.getCreated())
                .filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0)
                .count();

        //Then
        Assert.assertEquals(2, longTasks);
    }

    /* exercise 7.6 */
    @Test
    public void testAddTaskListAverageWorkingOnTask(){
        //Given
        Board project = testBoardHelper.prepareTestData();

        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));

        List<Integer> listOfDaysWorkingOnTask = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .map(t -> Period.between(t.getCreated(), LocalDate.now()).getDays())
                .collect(Collectors.toList());

        double avgNoOfDaysWorkingOnTask = IntStream.range(0, listOfDaysWorkingOnTask.size())
                .map(listOfDaysWorkingOnTask::get)
                .average().orElse(0);

        //Then
        Assert.assertEquals(3, listOfDaysWorkingOnTask.size());
        Assert.assertEquals(10, avgNoOfDaysWorkingOnTask, 0);
    }
}
