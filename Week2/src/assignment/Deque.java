package assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Deque<Item> implements Iterable<Item> {

    private Node first = null, last = null;
    private int size = 0;

    public Deque() {
    }

    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        if (oldFirst == null) {
            last = first;
        } else {
            first.next = oldFirst;
            oldFirst.prev = first;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) first = last;
        else {
            oldLast.next = last;
            last.prev = oldLast;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = (Item) first.item;
        first = first.next;
        if (isEmpty()) last = null;
        size--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = (Item) last.item;
        if (first == last) {
            first = null;
            last = null;
        } else {
            Node prevLast = last.prev;
            prevLast.next = null;
            last = prevLast;
        }
        size--;
        return item;
    }


    // return an iterator over items in order from front to back
    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator<Item> implements Iterator {

        Node node = first;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();
            Item item = (Item) node.item;
            node = node.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node<Item> {
        Item item;
        Node next;
        Node prev;
    }

    // unit testing (required)
    public static void main(String[] args) {
//        Deque<String> deque = new Deque<>();
//
//        Scanner scan = new Scanner(System.in);
//        while (true) {
//            System.out.println("1. size ?");
//            System.out.println("2. addFirst");
//            System.out.println("3. addLast");
//            System.out.println("4. remove first");
//            System.out.println("5. remove last");
//            System.out.println("6. print");
//            int choice = scan.nextInt();
//
//            if (choice == 1) {
//                System.out.println(deque.size());
//            } else if (choice == 2) {
//                String item = scan.next();
//                deque.addFirst(item);
//            } else if (choice == 3) {
//                String item = scan.next();
//                deque.addLast(item);
//            } else if (choice == 4) {
//                System.out.println(deque.removeFirst());
//            } else if (choice == 5) {
//                System.out.println(deque.removeLast());
//            } else if (choice == 6) {
//
//            } else {
//                break;
//            }
//        }
    }

}
