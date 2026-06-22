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
            shapeCollector.addFigure(circle);

            Shape result = shapeCollector.getFigure(0);

            Assertions.assertEquals(circle, result);
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
    }
}
