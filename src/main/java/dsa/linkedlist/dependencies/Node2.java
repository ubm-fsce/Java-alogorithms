package dsa.linkedlist.dependencies;

public class Node2 {
    public  int data;
    public Node2 next = null;
    public Node2 previous = null; /* This is for doubly linked list only */

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
