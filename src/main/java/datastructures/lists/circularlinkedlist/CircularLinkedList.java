package datastructures.lists.circularlinkedlist;

import datastructures.lists.linkedlist.Node;

public class CircularLinkedList {

    private Node first;
    private Node last;

    public CircularLinkedList() {
        first = null;
        last = null;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int data) {
        Node node = new Node();
        node.setData(data);
        if (isEmpty()) {
            last = node;
        }
        node.setNext(first);  /*new node --> old First*/
        first = node;  /*First place */
    }

    public void insertLast(int data) {
        Node node = new Node();
        node.setData(data);
        if (isEmpty()) {
            first = node;
        } else {
            last.setNext(node); /*the next value of the lat node will point to new node*/
            last = node;  /*we make the new node we created*/
        }

    }

    public int deleteFirst() {
        int temp = first.getData();
        if (first.getNext() == null) {  // only single node is avaible so set last as null
            last = null;
        }
        first = first.getNext(); // first point to old next value
        return temp;
    }

    public int deleteLast() {
     Node current = first;
     Node previous = first;
     while (current.getNext()!=null){
       previous = current;
         current = current.getNext();
     }
     int temp = current.getData();
    previous.setNext(null);
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
