package com.kodilla.patterns.factory.tasks;

public final class DrivingTask implements Task {
    final private String taskName;
    final private String where;
    final private String using;
    private boolean isExecuted;

    public DrivingTask(final String taskName, final String where, final String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
        isExecuted = false;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing driving task '" + taskName);
        isExecuted = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return isExecuted;
    }
}
