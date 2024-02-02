package linkedList;

import edu.princeton.cs.algs4.StdRandom;

public class ShuffleLinkedList {
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

    public Node getHead(){
        return head;
    }

    public int size(){
        return size;
    }

    public static void printList(Node node) {
        System.out.print("[");
        while(node != null){
            System.out.print(node.val + ", ");
            node = node.next;
        }
        System.out.println("]");
    }

    private static Node findMiddle(Node node){
        if(node == null) return node;
        Node slow = node, fast = node;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node merge(Node a, Node b){
        Node result = null;
        if(a == null) return b;
        if(b == null) return a;

        if(StdRandom.bernoulli()){
            result = a;
            result.next = merge(a.next, b);
        }else{
            result = b;
            result.next = merge(a, b.next);
        }
        return result;
    }

    public static Node shuffle(Node h) {
        if(h == null || h.next == null) return h;

        Node mid = findMiddle(h);
        Node nextOfMid = mid.next;

        mid.next = null;
        Node left = shuffle(h);
        Node right = shuffle(nextOfMid);
        return merge(left, right);
    }

    public static void main(String[] args) {
        ShuffleLinkedList llist = new ShuffleLinkedList();
        llist.add(3);
        llist.add(33);
        llist.add(2);
        llist.add(18);
        llist.add(90);
        llist.add(9);
        llist.add(11);
        System.out.println("Before Shuffle : ");
        ShuffleLinkedList.printList(llist.getHead());
        Node shuffledLlist = ShuffleLinkedList.shuffle(llist.getHead());
        ShuffleLinkedList.printList(shuffledLlist);
    }


}
