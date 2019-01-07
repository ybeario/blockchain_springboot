package com.cqupt.bear.blockchain.common.utils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class NullSafeIterable<T> implements Iterable<T> {
    private Iterable<T> iterable;

    private T[] array;

    private boolean isArray;

    public NullSafeIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    public NullSafeIterable(T[] array) {
        this.array = array;
        this.isArray = true;
    }

    public Iterator<T> iterator() {
        if (isArray) {
            if (array == null) {
                return new NullSafeIterator();
            } else {
                return Arrays.asList(array).iterator();
            }
        } else {
            if (iterable == null) {
                return new NullSafeIterator();
            } else {
                return iterable.iterator();
            }
        }

    }

    class NullSafeIterator implements Iterator<T> {

        public boolean hasNext() {
            return false;
        }

        public T next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }
}
