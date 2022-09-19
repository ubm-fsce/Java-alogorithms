package dsa.linkedlist;

public class Node2 {
    int data;
    Node2 next = null;
    Node2 previous = null; /* This is for doubly linked list only */

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void displayNode() {
        System.out.println("{ " + data + " } ");
    }

    public Node2 getNext() {
        return next;
    }

    public void setNext(Node2 next) {
        this.next = next;
    }
}
