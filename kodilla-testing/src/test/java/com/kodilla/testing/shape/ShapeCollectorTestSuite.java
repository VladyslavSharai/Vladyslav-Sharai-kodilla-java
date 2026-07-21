package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

@DisplayName("Test")
public class ShapeCollectorTestSuite {
    @BeforeAll
    static void beforeAll() {

        System.out.println("Before All");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }

    @Nested
    @DisplayName("Add and remowe shape whith collector")
    class TestAddAndRemoveShaoe {
        @Test
        void addShape() {
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle(4);

            shapeCollector.addFigure(circle);

            Assertions.assertEquals(circle, shapeCollector.getFigure(0));
        }

        @Test
        void removeShape() {
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle(4);
            shapeCollector.addFigure(circle);

            boolean result = shapeCollector.removeFigure(circle);

            Assertions.assertTrue(result);
            Assertions.assertNull(shapeCollector.getFigure(0));
        }
    }

    @Nested
    @DisplayName("Tests for retrieving and showing shapes")
    class TestGetAndShowShape {
        @Test
        void getFigure() {
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle(4);
            Square square = new Square(4);
            Triangle triangle = new Triangle(4, 4);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);

            Shape resultCircle = shapeCollector.getFigure(0);
            Shape resultSquare = shapeCollector.getFigure(1);
            Shape resultTriangle = shapeCollector.getFigure(2);

            Assertions.assertEquals(circle, resultCircle);
            Assertions.assertEquals(square, resultSquare);
            Assertions.assertEquals(triangle, resultTriangle);
        }

        @Test
        void showFigures() {
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle(4);
            Square square = new Square(4);
            Triangle triangle = new Triangle(4, 4);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(triangle);

            String result = shapeCollector.showFigures();
            String expectedResult = "Square, Circle, Triangle";

            Assertions.assertEquals(expectedResult, result);
        }

        @Test
        void removeFigureNotPresentInCollection(){
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle(4);
            Triangle triangle = new Triangle(4, 4);
            shapeCollector.addFigure(circle);

            boolean result =  shapeCollector.removeFigure(triangle);

            Assertions.assertFalse(result);
            Assertions.assertEquals(circle, shapeCollector.getFigure(0));
        }

        @Test
        void showFiguresWithNotIndex(){
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square(4);
            shapeCollector.addFigure(square);

            Shape negativeIndex = shapeCollector.getFigure(-1);
            Shape inativeIndex = shapeCollector.getFigure(1);

            Assertions.assertNull(negativeIndex);
            Assertions.assertNull(inativeIndex);
        }
    }
}
