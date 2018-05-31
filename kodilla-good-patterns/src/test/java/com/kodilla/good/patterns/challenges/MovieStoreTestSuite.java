package com.kodilla.good.patterns.challenges;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class MovieStoreTestSuite {
    @Test
    public void testGetMovies(){
        //Given
        MovieStore movieStore = new MovieStore();

        //When
        Map<String, List<String>> resultMap = movieStore.getMovies();

        //Then
        Assert.assertEquals(3, resultMap.size());
        Assert.assertTrue(resultMap.containsKey("IM"));
        Assert.assertTrue(resultMap.containsKey("AV"));
        Assert.assertTrue(resultMap.containsKey("FL"));
        Assert.assertTrue(resultMap.get("IM").contains("Żelazny Człowiek"));
        Assert.assertTrue(resultMap.get("IM").contains("Iron Man"));
        Assert.assertTrue(resultMap.get("AV").contains("Mściciele"));
        Assert.assertTrue(resultMap.get("AV").contains("Avengers"));
        Assert.assertTrue(resultMap.get("FL").contains("Błyskawica"));
        Assert.assertTrue(resultMap.get("FL").contains("Flash"));

        System.out.println("Exercise 9.1 according to instructions:");
        resultMap.entrySet().stream()
                .flatMap(l -> l.getValue().stream())
                .forEach(x -> System.out.print(x + "!"));

        System.out.println("\nMy version of exercise:");
        resultMap.entrySet().stream()
                .map(f -> f.getValue())
                .forEach(x -> System.out.println(x));
    }
}
