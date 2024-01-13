package stack;

import java.util.Scanner;

public class ResizingArrayStackOfStrings {

    private String[] stack = null;
    private int n = 0;

    public ResizingArrayStackOfStrings(){
        stack = new String[1];
    }

    public void push(String item){
        if(n == stack.length){
            resize(n*2);
        }
        stack[n++] = item;
    }

    public String pop(){
        if(isEmpty()) throw new ArrayIndexOutOfBoundsException("Empty Stack");
        String item = stack[--n];
        stack[n] = null;
        if(n > 0 && n == stack.length/4){ resize(stack.length/2); }
        return item;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    private void resize(int capacity){
        String[] newStack = new String[capacity];
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
        ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();
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
