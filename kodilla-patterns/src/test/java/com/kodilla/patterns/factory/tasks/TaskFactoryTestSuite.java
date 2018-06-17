package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task task = taskFactory.makeTask(TaskTypes.SHOPPING);
        boolean beforeExecution = task.isTaskExecuted();
        task.executeTask();
        boolean afterExecution = task.isTaskExecuted();

        //Then
        Assert.assertNotNull(task);
        Assert.assertEquals("Shopping task", task.getTaskName());
        Assert.assertFalse(beforeExecution);
        Assert.assertTrue(afterExecution);
    }

    @Test
    public void testFactoryDrivingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task task = taskFactory.makeTask(TaskTypes.DRIVING);
        boolean beforeExecution = task.isTaskExecuted();
        task.executeTask();
        boolean afterExecution = task.isTaskExecuted();

        //Then
        Assert.assertNotNull(task);
        Assert.assertEquals("Driving task", task.getTaskName());
        Assert.assertFalse(beforeExecution);
        Assert.assertTrue(afterExecution);
    }

    @Test
    public void testFactoryPaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task task = taskFactory.makeTask(TaskTypes.PAINTING);
        boolean beforeExecution = task.isTaskExecuted();
        task.executeTask();
        boolean afterExecution = task.isTaskExecuted();

        //Then
        Assert.assertNotNull(task);
        Assert.assertEquals("Painting task", task.getTaskName());
        Assert.assertFalse(beforeExecution);
        Assert.assertTrue(afterExecution);
    }
}
