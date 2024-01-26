package assignment;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int first = -1, last = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {
        items = (Item[]) new Object[2];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return first == -1;
    }

    // return the number of items on the randomized queue
    public int size() {
        if (first == -1) return 0;
        return last > first ? last - first : items.length + last - first;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        items[last] = item;
        last = (last + 1) % items.length;
        if (first == -1) first = 0;
        if (last == first - 1 || last - first + 1 == items.length) {
            resize(items.length * 2);
        }
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int index = (first + StdRandom.uniformInt(size())) % items.length;
//        System.out.println("Index to be removed " + index);
        Item item = items[index];
//        System.out.println("item to be removed " + item);
        remove(index);
        if (!isEmpty() && size() == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        int index = StdRandom.uniformInt(size());
        return items[(first + index) % size()];
    }

    private void print() {
        for (Item i : items) {
            System.out.println(i);
        }
    }

    // return an independent iterator over items in random order
    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {

        int index = first;

        @Override
        public boolean hasNext() {
            return index < last;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = items[index];
            index = (index + 1) % items.length;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        int len = items.length;
        int n = size();
        for (int i = 0; i < n; i++) {
            copy[i] = items[(i + first) % len];
        }
        items = copy;
        first = 0;
        last = n;
    }

    private void remove(int index) {
        items[index] = null;
        int i = 0, len = items.length, n = size();
        for (i = 0; i < n - index - 1; i++) {
            items[(index + i) % len] = items[(index + i + 1) % len];
        }
        items[index + i] = null;
        if (last == 0) last = n - 1;
        else last--;
        if (first == last) first = -1;
    }


    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> queue = new RandomizedQueue<>();

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("1. size ?");
            System.out.println("2. enqueue");
            System.out.println("3. dequeue");
            System.out.println("4. sample");
            System.out.println("5. print");
            System.out.println("6. empty ?");
            int choice = scan.nextInt();

            if (choice == 1) {
                System.out.println(queue.size());
            } else if (choice == 2) {
                String item = scan.next();
                queue.enqueue(item);
            } else if (choice == 3) {
                System.out.println(queue.dequeue());
            } else if (choice == 4) {
                System.out.println(queue.sample());
            } else if (choice == 5) {
                queue.print();
            } else if (choice == 6) {
                System.out.println(queue.isEmpty());
            } else {
                break;
            }
        }
    }

}
