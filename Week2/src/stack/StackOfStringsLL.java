package stack;

import java.util.Scanner;

public class StackOfStringsLL {
    private Node first = null;

    private class Node{
        String item;
        Node next;
    }

    public StackOfStringsLL(){
    }

    public void push(String item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
    }

    public String pop(){
        if(isEmpty()) return "Stack Empty";
        String item = first.item;
        first = first.next;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args){
        StackOfStringsLL stack = new StackOfStringsLL();
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String s = scan.next();
            if(s.equals("-")){
                System.out.println(stack.pop());
            }else{
                stack.push(s);
            }
        }
    }
}
