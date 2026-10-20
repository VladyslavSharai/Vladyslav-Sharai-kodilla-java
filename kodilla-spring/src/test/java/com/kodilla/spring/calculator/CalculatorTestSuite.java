package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;

    @Test
    public void testCalculations(){
        double resultAdd = calculator.add(1.0,2.0);
        double resultSub = calculator.sub(3.0,2.0);
        double resultMul = calculator.mul(4.0,2.0);
        double resultDiv = calculator.div(6.0,2.0);

        Assertions.assertEquals(resultAdd,3.0);
        Assertions.assertEquals(resultSub,1.0);
        Assertions.assertEquals(resultMul,8.0);
        Assertions.assertEquals(resultDiv,3.0);
    }
}

