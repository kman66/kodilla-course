package com.kodilla.patterns.factory.tasks;

public final class ShoppingTask implements Task {
    final private String taskName;
    final private String whatToBuy;
    final private double quantity;
    private boolean isExecuted;

    public ShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
        isExecuted = false;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing shopping task '" + taskName);
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
