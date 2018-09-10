package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTestSuite {
    @Test
    public void testUpdate() {
        //Given
        Student harryPotter = new Student("Harry Potter");
        Student jessieJames = new Student("Jessie James");
        Student louisVitton = new Student("Louis Vitton");
        Mentor janBrzechwa = new Mentor("Jan Brzechwa");
        Mentor johnBean = new Mentor("John Bean");
        harryPotter.registerObserver(johnBean);
        jessieJames.registerObserver(janBrzechwa);
        louisVitton.registerObserver(johnBean);
        //When
        harryPotter.addExercise("Mastering magic tricks");
        harryPotter.addExercise("Playing with other kids");
        jessieJames.addExercise("Learning SQL");
        jessieJames.addExercise("Writing exercises in java");
        jessieJames.addExercise("Creating some unit tests");
        louisVitton.addExercise("Making some funny stuff");
        //Then
        assertEquals(3, janBrzechwa.getUpdateCount());
        assertEquals(3, johnBean.getUpdateCount());
    }
}