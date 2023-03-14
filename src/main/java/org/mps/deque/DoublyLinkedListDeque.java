package org.mps.deque;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

/**
 * @author Nuria Rodríguez Tortosa e Hilaria Romero Bouyahia
 */

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        if (first == null) {
            // Si la lista está vacía, el primer nodo será el último también
            first = new DequeNode<>(value, null, null);
            last = first;
        } else {
            // Si la lista no está vacía, el nuevo nodo será el primer nodo
            // y su nodo siguiente será el antiguo primer nodo
            first = new DequeNode<>(value, null, first);
            first.getNext().setPrevious(first);
        }
        size++;
    }

    @Override
    public void append(T value) {
        if (last == null) {
            // Si la lista está vacía, el último nodo será el primero también
            last = new DequeNode<>(value, null, null);
            first = last;
        } else {
            // Si la lista no está vacía, el nuevo nodo será el primer nodo
            // y su nodo siguiente será el antiguo primer nodo
            last = new DequeNode<>(value, last, null);
            last.getPrevious().setNext(last);
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        first = first.getNext();
        size--;
    }

    @Override
    public void deleteLast() {
        last = last.getPrevious();
        size--;
    }

    @Override
    public T first() {
        // TODO
        if(first == null) {
            return null;
        } else {
            return first.getItem();
        }
    }

    @Override
    public T last() {
        if(last == null) {
            return null;
        } else {
            return last.getItem();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(first != null) {
            DequeNode<T> node = first;
            int cont = 0;
            boolean encontrado = false;
            while(node.getNext() != null && !encontrado) {
                if(cont != index) {
                    node = node.getNext();
                    cont++;
                } else {
                    encontrado = true;
                }
            }
            if(node != null && cont == index) return (T) node.getItem();
            if(encontrado) return (T) node.getItem();
        }
        if (last != null) {
            DequeNode<T> node = last;
            int cont = 0;
            boolean encontrado = false;
            while (node.getPrevious() != null && !encontrado) {
                if (cont != index) {
                    node = node.getPrevious();
                    cont++;
                } else {
                    encontrado = true;
                }
            }
            if(node != null && cont == index) return (T) node.getItem();
            if(encontrado) return (T) node.getItem();
        }

        return null;
    }

    @Override
    public boolean contains(T value) {
        DequeNode<T> node = first;
        while (node != null) {
            if (node.getItem().equals(value)) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    @Override
    public void remove(T value) {
        DequeNode<T> node = first;
        while (node != null) {
            if (node.getItem().equals(value)) {
                if (node == first) {
                    first = node.getNext();
                    if (first != null) {
                        first.setPrevious(null);
                    } else {
                        last = null;
                    }
                } else if (node == last) {
                    last = node.getPrevious();
                    if (last != null) {
                        last.setNext(null);
                    } else {
                        first = null;
                    }
                } else {
                    node.getPrevious().setNext(node.getNext());
                    node.getNext().setPrevious(node.getPrevious());
                }
                size--;
                return;
            }
            node = node.getNext();
        }
    }


    private T[] toArray() {
        T[] array = (T[]) new Object[size];
        DequeNode<T> node = first;
        for (int i = 0; i < size; i++) {
            array[i] = node.getItem();
            node = node.getNext();
        }
        return array;
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        T[] elements = toArray();

        Arrays.sort(elements, comparator);

        if (elements.length > 0) {
            first = new DequeNode<>(elements[0], null, null);
            DequeNode<T> node = first;
            for (int i = 1; i < elements.length; i++) {
                DequeNode<T> nextNode = new DequeNode<>(elements[i], node, null);
                node.setNext(nextNode);
                node = nextNode;
            }
            last = node;
        } else {
            first = null;
            last = null;
        }
    }

}
