package datastructures.doublylinkedlist;

public class Node {
    int data;
    Node next = null;
    Node previous = null;

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

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
