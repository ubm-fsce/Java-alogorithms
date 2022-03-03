package uday.dsa.linkedlist;

public class Node {
    int data;
    Node next = null;
    Node previous =null;  /*This is for doubly linked list only*/

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void displayNode() {
        System.out.println("{ " + data + " } ");
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
