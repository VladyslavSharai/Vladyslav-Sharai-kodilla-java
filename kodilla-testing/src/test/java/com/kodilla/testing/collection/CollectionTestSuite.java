package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;
import java.util.*;

@DisplayName("Collection Test Suite")
class CollectionTestSuite {
    @BeforeEach
    public void beforeEach() {
        System.out.println("Start test list");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("End test list");
    }

    @DisplayName("Test empty list")
    @Test
    public void testOddNumbersExterminatorEmptyList(){

        OddNumbersExterminator o = new OddNumbersExterminator();

        List<Integer> emptyList = Arrays.asList();
        List <Integer> expectedResult = Arrays.asList();
        List <Integer> result = o.exterminate(emptyList);

        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName("Test Even Numbers")
    @Test
    public void testOddNumbersExterminatorNormalList(){

        OddNumbersExterminator o = new OddNumbersExterminator();

        List<Integer> normalList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List <Integer> expectedResult = Arrays.asList(2,4,6,8,10);
        List <Integer> result = o.exterminate(normalList);

        Assertions.assertEquals(expectedResult, result);
    }
}
