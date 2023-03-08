package org.mps.deque;

/*
 * Test cases
 * When creating a node with only an item, without previous or next node
 * 1. getItem() -> actual item
 * 2. setItem(x) -> x == getItem()
 * 3. getPrevious() -> null
 * 4. getNext() -> null
 * 5. isNotATerminalNode() -> false
 *
 * When adding to the node the previous and next node
 * 6. setPrevious(nodePrevious) -> nodePrevious == getPrevious()
 * 7. setNext(nodeNext) -> nodeNext == getNext()
 * 8. isNotATerminalNode() -> true
 * 9. getPrevious().isNotATerminalNode() -> false
 * 10. getNext().isNotATerminalNode() -> false
 * */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Nuria Rodríguez Tortosa e Hilaria Romero Bouyahia
 */
@Nested
@DisplayName("DequeNode")
class DequeNodeTest {

    DequeNode<Integer> node;

    @BeforeEach
    void init() { node = new DequeNode<>(4, null, null); }

    @AfterEach
    void shutDown(){ node = null;}


    @Nested
    @DisplayName("Test cases when creating a DequeNode with only an item")
    class UnNodoSoloConItemSinPreviousNiNext {
        @Test
        @DisplayName("the item is created correctly")
        public void ElItemDelDequeNodeSeCreaCorrectamente() {
            int obtainedValue = node.getItem();
            int expectedValue = 4;

            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("the item is changed correctly")
        public void TheItemIsChangedCorrectly() {
            node.setItem(6);
            int expectedValue = 6;
            int obtainedValue = node.getItem();

            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("the previous node is null")
        public void ElNodoPrevioDelDequeNodeSeCreaCorrectamente() {
            assertNull(node.getPrevious());
        }

        @Test
        @DisplayName("the next node is null")
        public void ElNodoPosteriorDelDequeNodeSeCreaCorrectamente() {
            assertNull(node.getNext());
        }

        @Test
        @DisplayName("this node is not a terminal node")
        public void ElNodoNoEsTerminal() {
            boolean expectedValue = false;
            boolean obtainedValue = node.isNotATerminalNode();

            assertEquals(expectedValue, obtainedValue);
        }

        @Nested
        @DisplayName("when adding previous and next nodes")
        class AlNodoSeLeAnyadenLosNodosPreviousYNext {
            @Test
            @DisplayName("the previous node is created correctly")
            public void ElNodoPrevioSeCreaCorrectamente() {
                DequeNode<Integer> expectedValue = new DequeNode<>(5, null, node);

                node.setPrevious(expectedValue);
                DequeNode<Integer> obtainedValue = node.getPrevious();

                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("the next node is created correctly")
            public void ElNodoPosteriorSeCreaCorrectamente() {
                DequeNode<Integer> expectedValue = new DequeNode<>(5, node, null);

                node.setNext(expectedValue);
                DequeNode<Integer> obtainedValue = node.getNext();

                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("this node is now a terminal node")
            public void ElNodoConPreviousYNextEsUnTerminal(){
                node.setPrevious(new DequeNode<>(5, null, node));
                node.setNext(new DequeNode<>(5, node, null));

                boolean expectedValue = true;
                boolean obtainedValue = node.isNotATerminalNode();

                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("the previous node is not a terminal node")
            public void ElNodoPrevioNoEsUnTerminal(){
                node.setPrevious(new DequeNode<>(5, null, node));

                boolean expectedValue = false;
                boolean obtainedValue = node.getPrevious().isNotATerminalNode();

                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("the next node is not a terminal node")
            public void ElNodoSiguienteNoEsUnTerminal(){
                node.setNext(new DequeNode<>(5, node, null));

                boolean expectedValue = false;
                boolean obtainedValue = node.getNext().isNotATerminalNode();

                assertEquals(expectedValue, obtainedValue);
            }
        }
    }

}