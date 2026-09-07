package com.kodilla.exception.test;

public class ExceptionHandling {

    public String handleException(double x, double y) {
        SecondChallenge secondChallenge = new SecondChallenge();
        String result = "";

        try {
            result = secondChallenge.probablyIWillThrowException(x, y);
        } catch (Exception e) {
            System.out.println("Handled exception: Argument values are invalid (x=" + x + ", y=" + y + ")");
            result = "Error occurred!";
        } finally {
            System.out.println("Execution completed.");
        }

        return result;
    }
}
