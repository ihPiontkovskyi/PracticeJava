package edu.training.lesson1;

public class MyQueue<T> {


    private final Entry<T> header;

    {
        header = new Entry<>(null);
        header.next = header;
        header.prev = header;
    }

    public void add(T value) {
        Entry<T> newEntry = new Entry<>(value);

    }

    private void add(Entry<T> newEntry, Entry<T> prev, Entry<T> next) {
        prev.next = newEntry;
        newEntry.next = next;
        next.prev = newEntry;
        newEntry.prev = prev;
    }

    private static class Entry<T> {
        T value;
        Entry<T> prev;
        Entry<T> next;

        public Entry(T value) {
            this.value = value;
        }
    }

}
