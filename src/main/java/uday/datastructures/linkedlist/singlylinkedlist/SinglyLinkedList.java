package uday.datastructures.linkedlist.singlylinkedlist;

import uday.datastructures.linkedlist.Node;

public class SinglyLinkedList {
    private Node first;


    public SinglyLinkedList() {
    }

    public boolean isEmpty() {
        return (first == null);
    }

    /* used to INSERT at the beginning  of the list */
    public void insertFirst(int data) {
        Node node = new Node();
        node.setNext(first);
        node.setData(data);
        first = node;
    }

    /* used to INSERT at the Last  of the list */
    public void insertLast(int data) {
        Node current = first;
        while (current.getNext() != null) {
            current = current.getNext();  // loop until last to get last Node reference
        }
        Node newNode = new Node();
        newNode.setData(data);
        current.setNext(newNode);
    }


    /* used to DELETE at the beginning  of the list */
    public Node deleteFirst() {
        Node temp = first;
        first = first.getNext();
        return temp;
    }

    public void displayList() {
        System.out.println("List First-> Last");
        Node current = first;
        while (current.getNext() != null) {
            current.displayNode();
            current = current.getNext();
        }
        current.displayNode();
    }
}
