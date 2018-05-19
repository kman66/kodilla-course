package com.kodilla.stream.lambda;

public class ExpressionExecutor {
    public double executeExpression(double a, double b, MathExpression mathExpression) {
        return mathExpression.calculateExpression(a, b);
    }
}
