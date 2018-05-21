package com.kodilla.stream.beautifier;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeautifierTestSuite {
    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests(){
        System.out.println("All tests are finished.");
    }

    @Test
    public void testBeutify(){
        //Given
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        //When
        String testBig = poemBeautifier.beautify("test", text -> text.toUpperCase());
        String testAbc = poemBeautifier.beautify("test", text -> "ABC" + text + "ABC");
        String testReplaceS = poemBeautifier.beautify("test", text -> text.replace('s', 'x'));
        String testConcat = poemBeautifier.beautify("test", text -> text.concat(" done successfully"));

        //Then
        Assert.assertEquals("TEST", testBig);
        Assert.assertEquals("ABCtestABC", testAbc);
        Assert.assertEquals("text", testReplaceS);
        Assert.assertEquals("test done successfully", testConcat);
    }
}
