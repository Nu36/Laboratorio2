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
 * 13. .last() -> null
 * 14. .size() -> size--
 * When accesing the elements of the list
 * 15. .get(i) -> you get the element x that is in the index i
 * 16. .get(i), with i being >= to the size of the list -> ArrayIndexOutOfBoundsException
 * 17. .get(i), with i < 0 -> ArrayIndexOutOfBoundsException
 * 18. .contains(x) -> true
 * 19. .contains(y) -> false
 * 20. .remove(x) -> .contains(x) is false
 * 21. .remove(x) -> contains(y) is true because it was not deleted
 * 22. .remove(x) -> size--
 * 23. .sort() -> the list is sorted
 * 24. .sort on empty list -> RunTimeException
 * */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
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
        public void crearUnaDoublyLinkedListDeque() {
            assertNotNull(list);
        }


        @Test
        @DisplayName("size is cero")
        public void crearUnaDoublyLinkedListDequeTamanoCero() {
            int expectedValue = 0;
            int actualValue = list.size();
            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("first node is null")
        public void crearUnaDoublyLinkedListDequeFirst() {
            assertNull(list.first());
        }

        @Test
        @DisplayName("last node is null")
        public void crearUnaDoublyLinkedListDequeLast() {
            assertNull(list.last());
        }

        @Nested
        @DisplayName("when adding a node")
        class AnyadirNodoADoublyLinkedListDeque {

            @Nested
            @DisplayName("from the start")
            class AnyadirPorElInicioADoublyLinkedListDeque {

                @Test
                @DisplayName("is added correctly")
                public void anyadirNodoPorElInicioADoublyLinkedListDeque() {
                    int expectedValue = 1;

                    list.prepend(1);

                    int actualValue = list.first();
                    assertEquals(expectedValue, actualValue);
                }


                @Test
                @DisplayName("first is not null")
                public void anyadirFirstNoEsNullADoublyLinkedListDeque() {
                    int expectedValue = 1;

                    list.prepend(1);

                    assertNotNull(list.first());
                }

                @Test
                @DisplayName("size is incremented correctly")
                public void tamanyoEsIncrementadoInicioDoublyLinkedListDeque() {
                    int expectedValue = 2;

                    list.prepend(1);
                    list.prepend(1);

                    int actualValue = list.size();
                    assertEquals(expectedValue, actualValue);
                }
            }

            @Nested
            @DisplayName("from the end")
            class AnyadirPorElFinalADoublyLinkedListDeque {

                @Test
                @DisplayName("is added correctly")
                public void anyadirNodoPorElFinalADoublyLinkedListDeque() {
                    int expectedValue = 1;

                    list.append(1);

                    int actualValue = list.last();
                    assertEquals(expectedValue, actualValue);
                }

                @Test
                @DisplayName("last is not null")
                public void anyadirLastNoEsNullADoublyLinkedListDeque() {
                    int expectedValue = 1;

                    list.append(1);

                    assertNotNull(list.last());
                }


                @Test
                @DisplayName("size is incremented correctly")
                public void tamanyoEsIncrementadoFinalDoublyLinkedListDeque() {
                    int expectedValue = 2;

                    list.append(1);
                    list.append(1);

                    int actualValue = list.size();
                    assertEquals(expectedValue, actualValue);
                }
            }

            @Nested
            @DisplayName("when deleting a node")
            class eliminarNodoDeDoublyLinkedListDeque {

                @Nested
                @DisplayName("from the start")
                class deletingFromStartDoublyLinkedListDeque {

                    @Test
                    @DisplayName("first is null")
                    public void deletingFirstThenFirstIsNull() {
                        list.prepend(1);
                        list.deleteFirst();

                        assertNull(list.first());
                    }

                    @Test
                    @DisplayName("size is decreased")
                    public void deletingFirstThenSizeIsDecreased() {
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
                class deletingFromEndDoublyLinkedListDeque {
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

        @Nested
        @DisplayName("when accesing the elements of the list")
        class pruebasDeAcceso {

            @Nested
            @DisplayName("when getting")
            class pruebasGet {
                @Test
                @DisplayName("you can get an element that is in the list")
                public void conseguirElementoDeNodoEnUnaDoublyLinkedListDeque() {
                    list.prepend(4);
                    list.append(6);

                    int expectedValue = 6;
                    int obtainedValue = list.get(1);

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("you can get an element that is in the middle of the list")
                public void conseguirElementoDeNodoIntermedioEnUnaDoublyLinkedListDeque() {
                    list.prepend(4);
                    list.append(6);

                    int expectedValue = 6;
                    int obtainedValue = list.get(1);

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("you can't access an index superior or same as the size of the list")
                public void saltaExceptionAlAccederAUnTamanyoMayorEnUnaDoublyLinkedListDeque() {
                    list.prepend(4);
                    list.append(6);

                    assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(3));
                }

                @Test
                @DisplayName("you can't access an index under 0")
                public void saltaExceptionAlAccederAUnaPosicionNegativarEnUnaDoublyLinkedListDeque() {
                    list.prepend(4);
                    list.append(6);

                    assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(-1));
                }
            }

            @Nested
            @DisplayName("when seeing what it contains")
            class pruebasContains {
                @Test
                @DisplayName("you can see what the list contains")
                public void laListaContieneElElemento() {
                    list.prepend(4);
                    list.append(6);

                    assertTrue(list.contains(4) && list.contains(6));
                }

                @Test
                @DisplayName("you cannot see what the list does not contains")
                public void laListaNoContieneElElemento() {
                    list.prepend(4);
                    list.append(6);

                    assertFalse(list.contains(5));
                }
            }

            @Nested
            @DisplayName("when removing")
            class pruebasRemove {

                @Test
                @DisplayName("the item is removed from the list")
                public void seEliminaUnElementoDeLaLista() {
                    list.prepend(4);
                    list.append(6);

                    list.remove(4);

                    assertFalse(list.contains(4));
                }

                @Test
                @DisplayName("the previous middle DequeNode is linked correctly")
                public void correctamenteUnidos() {
                    list.prepend(0);
                    list.append(1);
                    list.append(2);
                    list.append(3);
                    list.append(4);
                    list.remove(2);

                    int expectedValue = 3;
                    int actualValue = list.get(2); //valor 3

                    assertEquals(expectedValue, actualValue);
                }

                @Test
                @DisplayName("the size is decremented")
                public void alEliminarSeDecrementaElTamano() {
                    list.prepend(0);
                    list.append(1);
                    list.append(2);
                    list.remove(2);

                    int expectedValue = 2;
                    int actualValue = list.size();

                    assertEquals(expectedValue, actualValue);
                }

                @Test
                @DisplayName("in a list with only one element")
                public void EliminarEnUnaListaConSoloUnElemento() {
                    list.prepend(4);

                    list.remove(4);

                    assertNull(list.first());
                    assertNull(list.last());
                }

                @Test
                @DisplayName("in an empty list")
                public void EliminarEnUnaListaVacia() {
                    assertThrows(RuntimeException.class, ()->list.remove(1));
                }
            }

            @Nested
            @DisplayName("when sorting")
            class pruebasSort {
                @Test
                @DisplayName("can sort the items of the list")
                public void seOrdenaLaLista(){
                    list.prepend(6);
                    list.append(4);
                    list.sort(Comparator.naturalOrder());

                    int expectedValue = 4;
                    int obtainedValue = list.get(0);

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("cannot sort the items of an empty list")
                public void NoSePuedeOrdenarUnaListaVacia(){
                    assertThrows(RuntimeException.class, () -> list.sort(Comparator.naturalOrder()));
                }
            }
        }
    }
}