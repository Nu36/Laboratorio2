package org.mps.deque;

/*
* Test cases
* When creating a list
* 1. Creating a list -> list != null
* 2. .size() -> 0
* 3. .first() -> null
* 4. .last() -> null
* Adding a node at the start
* 5. .prepend(x) -> .first() == x
* 6. .first() -> not null
* 7. .size() -> size++
* Adding a node at the end
* 8. .append(x) -> .last() == x
* 9. .last() -> not null
* 10. .size() -> size++
* Deleting from the start (.deleteFirst())
* 11. .first() -> null
* 12. .size() -> size--
* Deleting from the end (.deleteLast())
 * 11. .last() -> null
 * 12. .size() -> size--
 * */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Nuria Rodríguez Tortosa e Hilaria Romero Bouyahia
 */


@Nested
@DisplayName("DoublyLinkedList")
class DoublyLinkedListDequeTest {
    DoublyLinkedListDeque<Integer> list;

    @BeforeEach
    void init() { list = new DoublyLinkedListDeque<>(); }

    @AfterEach
    void shutDown(){list = null;}

    @Nested
    @DisplayName("Test cases when creating a list")
    class CreadaDoublyLinkedListDeque {
        @Test
        @DisplayName("the object is created")
        public void crearUnaDoublyLinkedListDeque(){
            assertNotNull(list);
        }


        @Test
        @DisplayName("size is cero")
        public void crearUnaDoublyLinkedListDequeTamanoCero(){
            int expectedValue = 0;
            int actualValue = list.size();
            assertEquals(expectedValue, actualValue);
        }
        @Test
        @DisplayName("first node is null")
        public void crearUnaDoublyLinkedListDequeFirst(){
            assertNull(list.first());
        }

        @Test
        @DisplayName("last node is null")
        public void crearUnaDoublyLinkedListDequeLast(){
            assertNull(list.last());
        }

        @Nested
        @DisplayName("when adding a node")
        class AnyadirNodoADoublyLinkedListDeque{

            @Nested
            @DisplayName("from the start")
            class AnyadirPorElInicioADoublyLinkedListDeque{

                @Test
                @DisplayName("is added correctly")
                public void anyadirNodoPorElInicioADoublyLinkedListDeque(){
                    int expectedValue = 1;

                    list.prepend(1);

                    int actualValue = list.first();
                    assertEquals(expectedValue, actualValue);
                }


                @Test
                @DisplayName("first is not null")
                public void anyadirFirstNoEsNullADoublyLinkedListDeque(){
                    int expectedValue = 1;

                    list.prepend(1);

                    assertNotNull(list.first());
                }

                @Test
                @DisplayName("size is incremented correctly")
                public void tamanyoEsIncrementadoInicioDoublyLinkedListDeque(){
                    int expectedValue = 2;

                    list.prepend(1);
                    list.prepend(1);

                    int actualValue = list.size();
                    assertEquals(expectedValue, actualValue);
                }
            }

            @Nested
            @DisplayName("from the end")
            class AnyadirPorElFinalADoublyLinkedListDeque{

                @Test
                @DisplayName("is added correctly")
                public void anyadirNodoPorElFinalADoublyLinkedListDeque(){
                    int expectedValue = 1;

                    list.append(1);

                    int actualValue = list.last();
                    assertEquals(expectedValue, actualValue);
                }

                @Test
                @DisplayName("last is not null")
                public void anyadirLastNoEsNullADoublyLinkedListDeque(){
                    int expectedValue = 1;

                    list.append(1);

                    assertNotNull(list.last());
                }


                @Test
                @DisplayName("size is incremented correctly")
                public void tamanyoEsIncrementadoFinalDoublyLinkedListDeque(){
                    int expectedValue = 2;

                    list.append(1);
                    list.append(1);

                    int actualValue = list.size();
                    assertEquals(expectedValue, actualValue);
                }
            }

            @Nested
            @DisplayName("when deleting a node")
            class eliminarNodoDeDoublyLinkedListDeque{

                @Nested
                @DisplayName("from the start")
                class deletingFromStartDoublyLinkedListDeque{

                    @Test
                    @DisplayName("first is null")
                    public void deletingFirstThenFirstIsNull(){
                        list.prepend(1);
                        list.deleteFirst();

                        assertNull(list.first());
                    }

                    @Test
                    @DisplayName("size is decreased")
                    public void deletingFirstThenSizeIsDecreased(){
                        list.prepend(1);
                        list.prepend(1);
                        list.deleteFirst();

                        int expectedValue = 1;
                        int actualValue = list.size();

                        assertEquals(expectedValue, actualValue);
                    }
                }

                @Nested
                @DisplayName("from the end")
                class deletingFromEndDoublyLinkedListDeque{
                    @Test
                    @DisplayName("last is null")
                    public void deletingLastThenLastIsNull() {
                        list.append(1);
                        list.deleteLast();

                        assertNull(list.last());
                    }

                    @Test
                    @DisplayName("size is decreased")
                    public void deletingLastThenSizeDecrease() {
                        list.append(1);
                        list.append(2);
                        list.deleteLast();

                        int expectedValue = 1;
                        int obtainedValue = list.size();

                        assertEquals(expectedValue, obtainedValue);
                    }
                }
            }
        }
    }
}