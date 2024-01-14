package queue;

import stack.ResizingArrayStackOfStrings;

import java.util.Scanner;

public class QueueOfStrings {

    private Node first = null, last = null;

    private class Node{
        String item;
        Node next;
    }

    public QueueOfStrings() {}

    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if(isEmpty()) first = last;
        else oldLast.next = last;
    }

    public String deque() {
        if(isEmpty()) throw new ArrayIndexOutOfBoundsException("Empty Queue");
        String item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        QueueOfStrings queue = new QueueOfStrings();
        while(true){
            System.out.println("Enter choice");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("4. isEmpty");

            int choice = scan.nextInt();
            if(choice == 1){
                System.out.println("enter value");
                String val = scan.next();
                queue.enqueue(val);
            }else if(choice == 2){
                System.out.println(queue.deque());
            }else if(choice == 3){
                System.out.println("Empty ? : " + queue.isEmpty());
            }else {
                break;
            }
        }
    }
}
