package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;
    private static ShapeCollector shapeCollector;

    @BeforeClass
    public static void beforeAllTests(){
        //Given
        shapeCollector = new ShapeCollector("ShapeCollectorTest");
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests(){
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddCircle(){
        //Given
        Shape circle = new Circle(4);

        //When
        shapeCollector.addFigure(circle);

        //Then
        Assert.assertEquals(1, shapeCollector.getFiguresQuantity());
        Assert.assertTrue(shapeCollector.containsFigure(circle));
    }

    @Test
    public void testAddSquare(){
        //Given
        Shape square = new Square(4);

        //When
        shapeCollector.addFigure(square);

        //Then
        Assert.assertEquals(1, shapeCollector.getFiguresQuantity());
        Assert.assertTrue(shapeCollector.containsFigure(square));
    }

    @Test
    public void testAddTriangle(){
        //Given
        Shape triangle = new Triangle(4, 3);

        //When
        shapeCollector.addFigure(triangle);

        //Then
        Assert.assertEquals(1, shapeCollector.getFiguresQuantity());
        Assert.assertTrue(shapeCollector.containsFigure(triangle));
    }

    @Test
    public void testRemoveCircleNotExisting(){
        //Given
        Shape circle = new Circle(4);

        //When
        boolean result = shapeCollector.removeFigure(circle);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveSquareNotExisting(){
        //Given
        Shape square = new Square(4);

        //When
        boolean result = shapeCollector.removeFigure(square);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveTriangleNotExisting(){
        //Given
        Shape triangle = new Triangle(4, 3);

        //When
        boolean result = shapeCollector.removeFigure(triangle);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveCircle(){
        //Given
        Shape circle = new Circle(10);
        shapeCollector.addFigure(circle);

        //When
        boolean result = shapeCollector.removeFigure(circle);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.getFiguresQuantity());
        Assert.assertFalse(shapeCollector.containsFigure(circle));
    }

    @Test
    public void testRemoveSquare(){
        //Given
        Shape square = new Square(10);
        shapeCollector.addFigure(square);

        //When
        boolean result = shapeCollector.removeFigure(square);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.getFiguresQuantity());
        Assert.assertFalse(shapeCollector.containsFigure(square));
    }

    @Test
    public void testRemoveTriangle(){
        //Given
        Shape triangle = new Triangle(10, 5);
        shapeCollector.addFigure(triangle);

        //When
        boolean result = shapeCollector.removeFigure(triangle);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.getFiguresQuantity());
        Assert.assertFalse(shapeCollector.containsFigure(triangle));
    }

    @Test
    public void testGetCircle(){
        //Given
        Shape circle = new Circle(15);
        shapeCollector.addFigure(circle);

        //When
        Shape retrievedShape;
        retrievedShape = shapeCollector.getFigure(0);

        //Then
        Assert.assertTrue(shapeCollector.containsFigure(circle));
        Assert.assertEquals(circle, retrievedShape);
    }

    @Test
    public void testGetSquare(){
        //Given
        Shape square = new Square(15);
        shapeCollector.addFigure(square);

        //When
        Shape retrievedShape;
        retrievedShape = shapeCollector.getFigure(0);

        //Then
        Assert.assertTrue(shapeCollector.containsFigure(square));
        Assert.assertEquals(square, retrievedShape);
    }

    @Test
    public void testGetTriangle(){
        //Given
        Shape triangle = new Triangle(15, 8);
        shapeCollector.addFigure(triangle);

        //When
        Shape retrievedShape;
        retrievedShape = shapeCollector.getFigure(0);

        //Then
        Assert.assertTrue(shapeCollector.containsFigure(triangle));
        Assert.assertEquals(triangle, retrievedShape);
    }

    @Test
    public void testFiguresQuantity(){
        //Given
        Shape circle = new Circle(2);
        Shape square = new Square(6);
        Shape triangle = new Triangle(6,8);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(triangle);

        //When
        int result = shapeCollector.getFiguresQuantity();

        //Then
        Assert.assertEquals(3, result);
    }

}
