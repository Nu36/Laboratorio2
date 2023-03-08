package org.mps.deque;

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
        first = new DequeNode<>(value, null, first);
        size++;
    }

    @Override
    public void append(T value) {
        last = new DequeNode<>(value, last, null);
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
}
