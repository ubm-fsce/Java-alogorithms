package dsa.linkedlist;

import dsa.linkedlist.dependencies.Node2;

public class LinkedListTests {
    public static void main(String[] args) {
        // nodeTest();
        // testSingularLinkedList();
        // testCircularLinkedList();
        testDoublyLinkedList();
    }

    private static void nodeTest() {
        Node2 nodeA = new Node2();
        nodeA.data = 3;

        Node2 nodeB = new Node2();
        nodeA.data = 7;

        Node2 nodeC = new Node2();
        nodeA.data = 9;

        Node2 nodeD = new Node2();
        nodeA.data = 15;

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
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

    private static void testDoublyLinkedList() {
        DoublyLinkiedList doublyLinkiedList = new DoublyLinkiedList();
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
