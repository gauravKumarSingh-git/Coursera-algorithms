package stack;

import java.util.Scanner;

public class StackOfStringsArray {

    private String[] stack = null;
    private int first = 0;

    public StackOfStringsArray(int n) {
        stack = new String[n];
    }

    public void push(String item){
        stack[first++] = item;
    }

    public String pop(){
        if(isEmpty()) throw new ArrayIndexOutOfBoundsException("Empty Stack");
        String item = stack[--first];
        stack[first] = null;
        return item;
    }

    public boolean isEmpty(){
        return first == 0;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        StackOfStringsArray stack = new StackOfStringsArray(10);
        while(true){
            System.out.println("Enter choice");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. isEmpty");

            int choice = scan.nextInt();
            if(choice == 1){
                System.out.println("enter value");
                String val = scan.next();
                stack.push(val);
            }else if(choice == 2){
                System.out.println(stack.pop());
            }else if(choice == 3){
                System.out.println("Empty ? : " + stack.isEmpty());
            }else {
                break;
            }
        }
    }
}
