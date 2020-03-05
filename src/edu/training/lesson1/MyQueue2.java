package edu.training.lesson1;

public class MyQueue2<T> extends MyLinkedList<T> {

    @Override
    public void add(T value) {
        addFirst(value);
    }

    public T element() {
        Entry<T> element = header.prev;
        removeLast();
        return element.value;
    }

    public static void main(String[] args) {
        MyQueue2<String> queue2 = new MyQueue2<>();

        queue2.add("first");
        queue2.add("3");
        System.out.println(queue2.element());
        queue2.add("second");

        System.out.println(queue2.element());
        System.out.println(queue2.element());
        System.out.println(queue2.size());
    }
}
