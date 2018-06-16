package com.kodilla.patterns.prototype;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.stream.IntStream;

public class BoardTestSuite {
    private static TasksList listToDo;
    private static TasksList listInProgress;
    private static TasksList listDone;

    @BeforeClass
    public static void generateLists() {
        //Given
        //creating the TasksList for todos
        listToDo = new TasksList("To Do Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To Do Task number " + n)));

        //creating the TaskList for tasks in progress
        listInProgress = new TasksList("In Progress Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("In Progress Task number " + n)));

        //creating the TaskList for done tasks
        listDone = new TasksList("Done Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done Task number " + n)));
    }

    public Board generateBoardInstance() {
        //creating the board and assigning the lists
        Board board = new Board("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);

        return board;
    }

    @Test
    public void testShallowCopy() {
        //Given
        Board board = generateBoardInstance();

        //making a shallow clone of object board
        Board clonedBoard = null;
        try {
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Project number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(board);
        System.out.println(clonedBoard);

        //When
        board.getLists().remove(listToDo);

        //Then
        Assert.assertEquals(2, board.getLists().size());
        Assert.assertEquals(2, clonedBoard.getLists().size());
        Assert.assertEquals(board.getLists(), clonedBoard.getLists());
    }

    @Test
    public void testDeepCopy() {
        //Given
        Board board = generateBoardInstance();

        //making a deep copy of object board
        Board deepClonedBoard = null;
        try {
            deepClonedBoard = board.deepCopy();
            deepClonedBoard.setName("Project number 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        board.getLists().remove(listToDo);

        //Then
        Assert.assertEquals(2, board.getLists().size());
        Assert.assertEquals(3, deepClonedBoard.getLists().size());
        Assert.assertNotEquals(deepClonedBoard.getLists(), board.getLists());
    }
}
