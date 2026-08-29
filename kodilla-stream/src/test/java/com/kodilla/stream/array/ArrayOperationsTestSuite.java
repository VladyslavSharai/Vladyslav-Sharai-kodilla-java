package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage(){
        int[] numbers = new int[] {
                5, 12, 8, 20, 15,
                3, 9, 14, 2, 18,
                7, 11, 6, 19, 10,
                4, 13, 1, 17, 16
        };

        double average = ArrayOperations.getAverage(numbers);

        Assertions.assertEquals(10.5, average);
    }
}
