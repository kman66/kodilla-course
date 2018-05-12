package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {
    private static OddNumbersExterminator oddNumbersExterminatorObject;

    @BeforeClass
    public static void beforeClass(){
        // Given
        oddNumbersExterminatorObject = new OddNumbersExterminator("Test");
    }

    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }

    @After
    public void after(){
        System.out.println("Test Case: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList(){
        System.out.println("Testing case of empty list");
        // When
        ArrayList<Integer> resultList = oddNumbersExterminatorObject.exterminate(new ArrayList<Integer>());
        // Then
        Assert.assertTrue("Empty list", resultList.isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList(){
        System.out.println("Testing normal case");
        // When
        ArrayList<Integer> resultList = oddNumbersExterminatorObject.exterminate(generateAndReturnTestList(1000));
        // Then
        Assert.assertTrue("Normal case", checkList(resultList));
    }

    private ArrayList<Integer> generateAndReturnTestList(int size){
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        for(Integer i=0; i<size; i++){
            tempList.add(i);
        }

        return tempList;
    }

    private boolean checkList(ArrayList<Integer> list){
        boolean isOdd = true;
        for(Integer i : list){
            if(i%2 != 0){
                isOdd = false;
                break;
            }
        }

        return isOdd;
    }
}
