package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class BoardTestSuite {
    @Test
    public void testAddTask() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        board.getDoneList().getTasks().add("creating new feature");
        board.getInProgressList().getTasks().add("fixing important bug");
        board.getToDoList().getTasks().add("executing unit tests");

        //When
        String taskFromDoneList = board.getDoneList().getTasks().get(0);
        String taskFromInProgressList = board.getInProgressList().getTasks().get(0);
        String taskFromToDoList = board.getToDoList().getTasks().get(0);


        //Then
        Assert.assertNotNull(board);
        Assert.assertEquals(1, board.getDoneList().getTasks().size());
        Assert.assertEquals(1, board.getInProgressList().getTasks().size());
        Assert.assertEquals(1, board.getToDoList().getTasks().size());
        Assert.assertEquals("creating new feature", taskFromDoneList);
        Assert.assertEquals("fixing important bug", taskFromInProgressList);
        Assert.assertEquals("executing unit tests", taskFromToDoList);
    }
}
