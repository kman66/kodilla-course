package com.kodilla.stream.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers){
        IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .forEach(n -> System.out.println(n));

        return IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average().orElse(0);
    }

    static double getAverageWithOf(int[] numbers){
        return IntStream.of(numbers).average().orElse(0);
    }
}
