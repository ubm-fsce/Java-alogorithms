package dsa.linkedlist;

import dsa.linkedlist.Node2;

public class SinglyLinkedList {
    private Node2 first;

    public SinglyLinkedList() {
    }

    public boolean isEmpty() {
        return (first == null);
    }

    /* used to INSERT at the beginning of the list */
    public void insertFirst(int data) {
        Node2 node = new Node2();
        node.setNext(first);
        node.setData(data);
        first = node;
    }

    /* used to INSERT at the Last of the list */
    public void insertLast(int data) {
        Node2 current = first;
        while (current.getNext() != null) {
            current = current.getNext(); // loop until last to get last Node reference
        }
        Node2 newNode = new Node2();
        newNode.setData(data);
        current.setNext(newNode);
    }

    /* used to DELETE at the beginning of the list */
    public Node2 deleteFirst() {
        Node2 temp = first;
        first = first.getNext();
        return temp;
    }

    public void displayList() {
        System.out.println("List First-> Last");
        Node2 current = first;
        while (current.getNext() != null) {
            current.displayNode();
            current = current.getNext();
        }
        current.displayNode();
    }
}
