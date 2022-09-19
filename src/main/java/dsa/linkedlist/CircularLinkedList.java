package dsa.linkedlist;

import dsa.dependencies.ListNode;

public class CircularLinkedList {

    private ListNode first;
    private ListNode last;

    public CircularLinkedList() {
        first = null;
        last = null;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int data) {
        ListNode node = new ListNode();
        node.setval(data);
        if (isEmpty()) {
            last = node;
        }
        node.setNext(first); /* new node --> old First */
        first = node; /* First place */
    }

    public void insertLast(int data) {
        ListNode node = new ListNode();
        node.setval(data);
        if (isEmpty()) {
            first = node;
        } else {
            last.setNext(node); /* the next value of the lat node will point to new node */
            last = node; /* we make the new node we created */
        }
    }

    public int deleteFirst() {
        int temp = first.getval();
        if (first.getNext() == null) { // only single node is avaible so set last as null
            last = null;
        }
        first = first.getNext(); // first point to old next value
        return temp;
    }

    public int deleteLast() {
        ListNode current = first;
        ListNode previous = first;
        while (current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }
        int temp = current.getval();
        previous.setNext(null);
        return temp;
    }

    public void displayList() {
        System.out.println("List First-> Last");
        ListNode current = first;
        while (current.getNext() != null) {
            current.displayNode();
            current = current.getNext();
        }
        current.displayNode();
    }

    public static void main(String[] args) {
        testCircularLinkedList();
    }

    private static void testCircularLinkedList() {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.insertFirst(1);
        circularLinkedList.insertFirst(2);
        circularLinkedList.insertFirst(3);
        circularLinkedList.insertFirst(4);
        circularLinkedList.insertFirst(5);
        circularLinkedList.insertFirst(6);
        circularLinkedList.insertLast(11);
        circularLinkedList.insertLast(12);
        circularLinkedList.insertLast(13);
        circularLinkedList.insertLast(14);
        circularLinkedList.insertLast(15);
        circularLinkedList.insertLast(16);
        circularLinkedList.deleteFirst();
        circularLinkedList.deleteLast();
        circularLinkedList.deleteFirst();
        circularLinkedList.deleteLast();
        circularLinkedList.deleteFirst();
        circularLinkedList.deleteLast();
        circularLinkedList.deleteFirst();
        circularLinkedList.deleteLast();
        circularLinkedList.displayList();
    }

}
