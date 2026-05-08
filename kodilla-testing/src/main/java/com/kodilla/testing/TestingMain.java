package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
public class TestingMain {
    public static void main(String[] args) {
        int a = 5;
        int b = 5;
        Calculator c = new Calculator();

        System.out.println("Testing method add");
        int resultAdd = c.add(a, b);
        if(resultAdd == 10) {
            System.out.println("Testing add: OK");
        }
        else  {
            System.out.println("Testing add: FAIL");
        }

        System.out.println("Testing method subtract");
        int resultSubtract = c.subtract(a, b);
        if(resultSubtract == 0) {
            System.out.println("Testing substract: OK");
        }
        else  {
            System.out.println("Testing substract: FAIL");
        }
    }
}
