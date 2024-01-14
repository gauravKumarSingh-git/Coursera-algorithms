package generics;

import stack.ResizingArrayStackOfStrings;

import java.util.Scanner;

/**
 * Generic array creation is not allowed in java, so have to do type casting
 */
public class GenericStack<Item> {
    private Item[] stack = null;
    private int n = 0;

    public GenericStack(){
        stack = (Item[]) new Object[1];
    }

    public void push(Item item){
        if(n == stack.length){
            resize(n*2);
        }
        stack[n++] = item;
    }

    public Item pop(){
        if(isEmpty()) throw new ArrayIndexOutOfBoundsException("Empty Stack");
        Item item = stack[--n];
        stack[n] = null;
        if(n > 0 && n == stack.length/4){ resize(stack.length/2); }
        return item;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    private void resize(int capacity){
        Item[] newStack = (Item[]) new Object[capacity];
        for(int i = 0; i < n; i++){
            newStack[i] = stack[i];
        }
        this.stack = newStack;
    }

    public String stackLength(){
        return "capacity : " + stack.length + " size : " + n;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        GenericStack<Integer> stack = new GenericStack<>();
        while(true){
            System.out.println("Enter choice");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. capacity");
            System.out.println("4. isEmpty");

            int choice = scan.nextInt();
            if(choice == 1){
                System.out.println("enter value");
                int val = scan.nextInt();
                stack.push(val);
            }else if(choice == 2){
                System.out.println(stack.pop());
            }else if(choice == 3){
                System.out.println(stack.stackLength());
            }else if(choice == 4){
                System.out.println("Empty ? : " + stack.isEmpty());
            }else {
                break;
            }
        }
    }
}
