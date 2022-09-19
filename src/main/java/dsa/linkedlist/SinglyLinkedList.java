package dsa.linkedlist;

import dsa.dependencies.ListNode;

public class SinglyLinkedList {

    private ListNode first;

    public SinglyLinkedList() {
    }

    public boolean isEmpty() {
        return (first == null);
    }

    /* used to INSERT at the beginning of the list */
    public void insertFirst(int data) {
        ListNode node = new ListNode();
        node.setNext(first);
        node.setval(data);
        first = node;
    }

    /* used to INSERT at the Last of the list */
    public void insertLast(int data) {
        ListNode current = first;
        while (current.getNext() != null) {
            current = current.getNext(); // loop until last to get last Node reference
        }
        ListNode newNode = new ListNode();
        newNode.setval(data);
        current.setNext(newNode);
    }

    /* used to DELETE at the beginning of the list */
    public ListNode deleteFirst() {
        ListNode temp = first;
        first = first.getNext();
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

         testSingularLinkedList();


    }
    private static void testSingularLinkedList() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertFirst(1);
        singlyLinkedList.insertFirst(2);
        singlyLinkedList.insertFirst(3);
        singlyLinkedList.insertFirst(4);
        singlyLinkedList.insertFirst(5);
        singlyLinkedList.insertFirst(6);
        singlyLinkedList.insertLast(1);
        singlyLinkedList.insertLast(2);
        singlyLinkedList.insertLast(3);
        singlyLinkedList.insertLast(4);
        singlyLinkedList.insertLast(5);
        singlyLinkedList.insertLast(6);
        singlyLinkedList.displayList();
    }

}
