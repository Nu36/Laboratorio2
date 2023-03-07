package org.mps.deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;
@Nested
@DisplayName("DequeNode")
class DequeNodeTest {

    DequeNode<Integer> node;

    @BeforeEach
    void init() { node = new DequeNode<>(4, null, null); }

    @AfterEach
    void shutDown(){node = null;}

    @Test
    void ElItemDelDequeNodeSeCreaCorrectamente() {
        int obtainedValue = node.getItem();
        int expectedValue = 4;

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void ElNodoPrevioDelDequeNodeSeCreaCorrectamente() {
        DequeNode<Integer> expectedValue = null;
        DequeNode<Integer> obtainedValue = node.getPrevious();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void ElNodoPosteriorDelDequeNodeSeCreaCorrectamente() {
        DequeNode<Integer> expectedValue = null;
        DequeNode<Integer> obtainedValue = node.getPrevious();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void ElNodoNoEsTerminal() {
        boolean expectedValue = false;
        boolean obtainedValue = node.isNotATerminalNode();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void ElNodoPrevioSeCreaCorrectamente() {
        DequeNode<Integer> expectedValue = new DequeNode<>(5, null, node);
        node.setPrevious(expectedValue);
        DequeNode<Integer> obtainedValue = node.getPrevious();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void ElNodoPosteriorSeCreaCorrectamente() {
        DequeNode<Integer> expectedValue = new DequeNode<>(5, node, null);
        node.setNext(expectedValue);
        DequeNode<Integer> obtainedValue = node.getNext();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void ElNodoConPreviousYNextEsUnTerminal(){
        node.setPrevious(new DequeNode<>(5, null, node));
        node.setNext(new DequeNode<>(5, node, null));
        boolean expectedValue = true;
        boolean obtainedValue = node.isNotATerminalNode();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void ElNodoPrevioNoEsUnTerminal(){
        node.setPrevious(new DequeNode<>(5, null, node));
        boolean expectedValue = false;
        boolean obtainedValue = node.getPrevious().isNotATerminalNode();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void ElNodoSiguienteNoEsUnTerminal(){
        node.setPrevious(new DequeNode<>(5, node, null));
        boolean expectedValue = true;
        boolean obtainedValue = node.getPrevious().isNotATerminalNode();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void ElItemSePoneCorrectamente() {
        node.setItem(6);
        int expectedValue = 6;
        int obtainedValue = node.getItem();

        assertEquals(expectedValue, obtainedValue);
    }
}