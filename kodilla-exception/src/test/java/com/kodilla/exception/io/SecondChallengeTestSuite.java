package com.kodilla.exception.io;

import com.kodilla.exception.test.ExceptionHandling;
import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {
    SecondChallenge secondChallenge;
    ExceptionHandling exceptionHandling;

    @BeforeEach
    public void setUp()
    {
        secondChallenge = new SecondChallenge();
        exceptionHandling = new ExceptionHandling();

    }

    @Test
    void testProbablyIWillThrowExceptionShouldThrowException() {


        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.0, 2.0));
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.9, 2.0));
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.5, 1.5));
    }

    @Test
    void testProbablyIWillThrowExceptionBoundarySuccesses() {

        assertDoesNotThrow(() -> {
            String result = secondChallenge.probablyIWillThrowException(1.0, 2.0);
            assertEquals("Done!", result);
        });

        assertDoesNotThrow(() -> {
            String result = secondChallenge.probablyIWillThrowException(1.99, 1.49);
            assertEquals("Done!", result);
        });
    }

    @Test
    void testExceptionHandling() {

        String result = exceptionHandling.handleException(1.5, 2.0);
        assertEquals("Done!", result);
    }

    @Test
    void testHandleExceptionWhenExceptionIsThrown(){

        String result = exceptionHandling.handleException(2.0, 2.0);

        assertEquals("Error occurred!", result);
    }
}
