package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Student implements Observable {
    private final List<Observer> observers;
    private final Deque<String> exercises;
    private String name;

    public Student(String name) {
        observers = new ArrayList<>();
        exercises = new ArrayDeque<>();
        this.name = name;
    }

    public Deque<String> getExercises() {
        return exercises;
    }

    public String getName() {
        return name;
    }

    public void addExercise(String exercise) {
        exercises.offer(exercise);
        notifyObservers();
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
