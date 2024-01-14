package queue;

import stack.ResizingArrayStackOfStrings;

import java.util.Scanner;

public class ResizingQueueOfStrings {

    private String[] queue = null;
    int first = -1, last = 0;

    public ResizingQueueOfStrings(){
        queue = new String[2];
    }

    public void enqueue(String item){
        queue[last] = item;
        last = (last + 1)%queue.length;
        if(first == -1) first = 0;
        if(last == first-1 || last - first + 1 == queue.length){
            resize(queue.length*2);
        }
    }

    public String deque(){
        if(isEmpty()) throw new ArrayIndexOutOfBoundsException("Empty Queue");
        String item = queue[first];
        queue[first++] = null;
        if(first == last) {
            first = -1;
            last = 0;
        }
        if((last > first && last - first == queue.length/4) || (last < first && queue.length + last - first  == queue.length/4)){
            resize(queue.length/2);
        }

        return item;
    }

    public boolean isEmpty(){
        return first == -1;
    }

    private void resize(int capacity){
        String[] copy = new String[capacity];
        int len = queue.length;
        int n = last > first ? last - first : len + last - first;
        for(int i = 0; i < n; i++){
            copy[i] = queue[(i + first)%len];
        }
        queue = copy;
        first = 0;
        last = n;
    }

    public String capacity(){
        int n = last > first ? last - first : queue.length + last - first;
        if(first == -1) n = 0;
        return "Capacity: " + queue.length + " size: " + n;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ResizingQueueOfStrings queue = new ResizingQueueOfStrings();
        while(true){
            System.out.println("Enter choice");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. capacity");
            System.out.println("4. isEmpty");

            int choice = scan.nextInt();
            if(choice == 1){
                System.out.println("enter value");
                String val = scan.next();
                queue.enqueue(val);
            }else if(choice == 2){
                System.out.println(queue.deque());
            }else if(choice == 3){
                System.out.println(queue.capacity());
            }else if(choice == 4){
                System.out.println("Empty ? : " + queue.isEmpty());
            }else {
                break;
            }
        }
    }
}
