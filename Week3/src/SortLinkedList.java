
public class SortLinkedList {

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

    private Node merge(Node left , Node right){
        Node result = null;
        if(left == null) return right;
        if(right == null) return left;

        if(left.val <= right.val){
            result = left;
            result.next = merge(left.next, right);
        }
        else{
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }

    private Node sort(Node h){
        if(h == null || h.next == null){
            return h;
        }

        Node mid = findMiddle(h);
        Node nextOfMid = mid.next;
        mid.next = null;

        Node left = sort(h);
        Node right = sort(nextOfMid);

        return merge(left, right);

    }

    public static void main(String[] args) {
        SortLinkedList llist = new SortLinkedList();
        llist.add(5);
        llist.add(10);
        llist.add(3);
        llist.add(6);
        llist.add(1);

        System.out.println("Linked List before sort : " );
        SortLinkedList.printList(llist.getHead());

        Node head = llist.sort(llist.getHead());

        System.out.println("sorted linked list : ");
        SortLinkedList.printList(head);
    }
}