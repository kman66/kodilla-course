package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {
    private static OddNumbersExterminator oneo;

    @BeforeClass
    public static void beforeClass(){
        oneo = new OddNumbersExterminator("Test");
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
        Assert.assertTrue("Empty list", oneo.exterminate(new ArrayList<Integer>()).isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList(){
        System.out.println("Testing normal case");
        Assert.assertTrue("Normal case", checkList(oneo.exterminate(generateAndReturnTestList(1000))));
    }

    public ArrayList<Integer> generateAndReturnTestList(int size){
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        for(Integer i=0; i<size; i++){
            tempList.add(i);
        }

        return tempList;
    }

    public boolean checkList(ArrayList<Integer> list){
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
