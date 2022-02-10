package com.adt.ds.linkedlist;

public class TestLinkedList {
    public static void main(String[] args) {
        Node nodeA = new Node();
        nodeA.data = 3;

        Node nodeB = new Node();
        nodeA.data = 7;

        Node nodeC = new Node();
        nodeA.data = 9;

        Node nodeD = new Node();
        nodeA.data = 15;

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;

    }
}
