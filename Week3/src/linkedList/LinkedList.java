package linkedList;

public class LinkedList {

    private Node head = new Node();
    private int size = 0;

    private class Node{
        int val;
        Node next;

        Node (){}
        Node(int val){
            this.val = val;
        }
    }

    public void add(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    public int size(){
        return size;
    }

    public void printList(Node node) {
        System.out.print("[");
        while(node != null){
            System.out.print(node.val + ", ");
            node = node.next;
        }
        System.out.println("]");
    }
}
