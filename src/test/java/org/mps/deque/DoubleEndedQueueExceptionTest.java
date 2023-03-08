package org.mps.deque;

/*
* Test Cases
* 1. new DoubleEndedQueueExceptionTest() -> not null
* 2. new DoubleEndedQueueExceptionTest(mensaje), .getMessage()-> mensaje
*/

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Nuria Rodríguez Tortosa e Hilaria Romero Bouyahia
 */
@Nested
@DisplayName("Test cases when creating an exception")
class DoubleEndedQueueExceptionTest {
    DoubleEndedQueueException exception;

    @BeforeEach
    void init() { exception = new DoubleEndedQueueException(null); }

    @AfterEach
    void shutDown(){exception = null;}

    @Nested
    @DisplayName("when creating an exception")
    class WhenCreatingAnException{

        @Test
        @DisplayName("object is created")
        public void creatingADoubleEndedQueueException(){
            assertNotNull(exception);
        }

        @Test
        @DisplayName("message is correct")
        public void creatingADoubleEndedQueueExceptionMessageIsCorrect(){
            exception = new DoubleEndedQueueException("prueba");

            String expectedValue = "prueba";
            String actualValue = exception.getMessage();

            assertEquals(expectedValue, actualValue);
        }

    }
}