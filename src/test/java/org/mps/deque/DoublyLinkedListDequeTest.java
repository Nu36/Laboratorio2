package org.mps.deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("DoublyLinkedList")
class DoublyLinkedListDequeTest {
    DoublyLinkedListDeque<Integer> list;

    @BeforeEach
    void init() { list = new DoublyLinkedListDeque<>(); }

    @AfterEach
    void shutDown(){list = null;}

    @DisplayName("al crear una lista")
    @Test
    public void crearUnaDoublyLinkedListDeque(){
        assertNotNull(list);
    }

    @DisplayName("el tamaño es cero")
    @Test
    public void crearUnaDoublyLinkedListDequeTamanoCero(){
        int expectedValue = 0;
        int actualValue = list.size();
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("el nodo inicial es null")
    @Test
    public void crearUnaDoublyLinkedListDequeFirst(){
        assertNull(list.first());
    }

    @DisplayName("el nodo final es null")
    @Test
    public void crearUnaDoublyLinkedListDequeLast(){
        assertNull(list.last());
    }
}