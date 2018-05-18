package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("\nCalculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("\nExercise 7.1");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("test", text -> text.toUpperCase());
        poemBeautifier.beautify("test", text -> "ABC" + text + "ABC");
        poemBeautifier.beautify("test", text -> text.replace('s', 'x'));
        poemBeautifier.beautify("test", text -> text.concat(" done successfully"));

        System.out.println("\nUsing Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
