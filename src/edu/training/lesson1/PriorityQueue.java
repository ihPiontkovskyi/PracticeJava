package edu.training.lesson1;

import java.util.Comparator;

public class PriorityQueue<T> extends MyLinkedList<T> {

    private final Comparator<T> comparator;

    public PriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void add(T value) {
        add(get(value), value);
    }

    public T element() {
        Entry<T> element = header.prev;
        removeLast();
        return element.value;
    }

    private int get(T value) {
        if (header.next == header) {
            return 0;
        }
        int pos = 0;
        Entry<T> iter = header.next;
        while (comparator.compare(iter.value, value) < 0) {
            if (iter == header) {
                break;
            }
            pos++;
            iter = iter.next;
        }
        return pos;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>(Integer::compare);

        integerPriorityQueue.add(2);
        integerPriorityQueue.add(7);
        integerPriorityQueue.add(1);

        System.out.println(integerPriorityQueue.element());
        System.out.println(integerPriorityQueue.element());
        System.out.println(integerPriorityQueue.element());
    }
}
