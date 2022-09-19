package dsa.linkedlist;

import dsa.dependencies.ListNode;

public class DoublyLinkedList {

    ListNode first = null;
    ListNode last = null;

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first == null ? true : false;
    }

    public void insertFirst(int val) {
        ListNode ListNode = new ListNode();
        ListNode.setval(val);
        if (isEmpty()) {
            last = ListNode;
        } else {
            first.setPrevious(ListNode);
        }
        ListNode.setNext(first);
        first = ListNode;
    }

    public void insertLast(int val) {
        ListNode ListNode = new ListNode();
        ListNode.setval(val);
        if (isEmpty()) {
            first = ListNode;
        } else {
            last.setNext(ListNode);
        }
        ListNode.setPrevious(last);
        last = ListNode;
    }

    public ListNode deleteFirst() {
        ListNode temp = first;
        if (first.getNext() == null) {
            last = null;
        } else {
            first.getNext().setPrevious(null);
        }
        first = first.getNext();
        return temp;
    }

    public ListNode deleteLast() {
        ListNode temp = last;
        if (first.getNext() == null) {
            first = null;
        } else {
            last.getPrevious().setNext(null);
        }
        last = last.getPrevious();
        return temp;
    }

    public boolean insertAfter(int key, int val) {
        ListNode current = first;
        while (current.getval() != key) {
            current = current.getNext();
            if (current.getNext() == null)
                return false;
        }
        ListNode ListNode = new ListNode();
        ListNode.setval(val);
        if (current == last) {
            current.setNext(ListNode);
            last = ListNode;
        } else {
            ListNode.setNext(current.getNext());
            current.getNext().setPrevious(ListNode);
        }
        ListNode.setPrevious(current);
        current.setNext(ListNode);
        return true;
    }

    public ListNode deleteAfter(int key) {
        ListNode current = first;
        while (current.getval() != key) {
            current = current.getNext();
            if (current.getNext() == null) {
                return null;
            }
            if (current == first) {
                first.getNext().setPrevious(null);
                first = first.getNext();
            } else if (current == last) {
                current.getPrevious().setNext(null);
                last = current.getPrevious();
            } else {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
            }
        }
        return current;
    }

    public void displayForward() {
        System.out.println(" First |====>>>  last ");
        ListNode current = first;
        while (current.getNext() != null) {
            current.displayNode();
            current = current.getNext();
        }
        current.displayNode();
    }

    public void displayBackward() {
        System.out.println(" First <<<====|  Last ");
        ListNode current = last;
        while (current.getPrevious() != null) {
            current.displayNode();
            current = current.getPrevious();
        }
        current.displayNode();
    }


    public static void main(String[] args) {

        testDoublyLinkedList();


    }
    private static void testDoublyLinkedList() {
        DoublyLinkedList doublyLinkiedList = new DoublyLinkedList();
        doublyLinkiedList.insertFirst(1);
        doublyLinkiedList.insertFirst(2);
        doublyLinkiedList.insertFirst(3);
        doublyLinkiedList.insertFirst(4);
        doublyLinkiedList.insertFirst(5);
        doublyLinkiedList.insertFirst(6);
        doublyLinkiedList.insertLast(11);
        doublyLinkiedList.insertLast(12);
        doublyLinkiedList.insertLast(13);
        doublyLinkiedList.insertLast(14);
        doublyLinkiedList.insertLast(15);
        doublyLinkiedList.insertLast(16);
        doublyLinkiedList.deleteFirst();
        doublyLinkiedList.deleteLast();
        doublyLinkiedList.deleteFirst();
        doublyLinkiedList.deleteLast();
        doublyLinkiedList.deleteFirst();
        doublyLinkiedList.deleteLast();
        doublyLinkiedList.deleteFirst();
        doublyLinkiedList.deleteLast();
        doublyLinkiedList.displayForward();
        ;
        doublyLinkiedList.displayBackward();
        ;
    }

}
