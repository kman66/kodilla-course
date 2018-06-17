package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public final Task makeTask(final String taskType) {
        switch (taskType) {
            case TaskTypes.DRIVING:
                return new DrivingTask("Driving task", "Wroclaw", "Car");
            case TaskTypes.PAINTING:
                return new PaintingTask("Painting task", "blue", "paper");
            case TaskTypes.SHOPPING:
                return new ShoppingTask("Shopping task", "computer", 4500.0);
            default:
                return null;
        }
    }
}
