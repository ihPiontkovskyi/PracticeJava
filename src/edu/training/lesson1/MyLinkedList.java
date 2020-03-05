package edu.training.lesson1;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {

    protected final Entry<T> header;

    private int size = 0;

    {
        header = new Entry<>(null);
        header.next = header;
        header.prev = header;
    }

    public void add(T value) {
        addLast(value);

    }

    public void add(int index, T value) {
        Entry<T> entryOnPosition = get(index);
        Entry<T> newEntry = new Entry<>(value);
        add(newEntry, entryOnPosition.prev, entryOnPosition);
    }

    public int size() {
        return size;
    }

    public T getValue(int index) {
        return get(index).value;
    }

    public void addLast(T value) {
        Entry<T> newEntry = new Entry<>(value);
        add(newEntry, header.prev, header);
    }

    public void removeFirst() {
        remove(header.next);
    }

    public void removeLast() {
        remove(header.prev);
    }

    public void remove(int index) {
        Entry<T> entryOnPosition = get(index);
        remove(entryOnPosition);
    }

    public void addFirst(T value) {
        Entry<T> newEntry = new Entry<>(value);
        add(newEntry, header, header.next);
    }

    protected Entry<T> get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("message");
        }
        int pos = 0;
        Entry<T> iter = header.next;
        while (pos != index) {
            if (iter == header) {
                throw new IndexOutOfBoundsException("another");
            }
            pos++;
            iter = iter.next;
        }
        return iter;
    }

    protected void add(Entry<T> newEntry, Entry<T> prev, Entry<T> next) {
        prev.next = newEntry;
        newEntry.next = next;
        next.prev = newEntry;
        newEntry.prev = prev;
        size++;
    }

    protected void remove(Entry<T> deleteEntry) {
        if (size == 0) {
            throw new NoSuchElementException("message");
        }
        Entry<T> prev = deleteEntry.prev;
        Entry<T> next = deleteEntry.next;
        deleteEntry.next = null;
        deleteEntry.prev = null;
        prev.next = next;
        next.prev = prev;
        size--;
    }

    protected class Entry<T> {
        T value;
        Entry<T> prev;
        Entry<T> next;

        public Entry(T value) {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Entry<T> iter = header.next;
        while (iter != header) {
            builder.append(iter.value).append(" ");
            iter = iter.next;
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        list.addFirst(10);

        list.add(2, 5);

        System.out.println(list);
    }
}
