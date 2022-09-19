package dsa.linkedlist;

import dsa.linkedlist.dependencies.Node;

public class DoublyLinkiedList {
    Node first = null;
    Node last = null;

    public DoublyLinkiedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first == null ? true : false;
    }

    public void insertFirst(int data) {
        Node node = new Node();
        node.setData(data);
        if (isEmpty()) {
            last = node;
        } else {
            first.setPrevious(node);
        }
        node.setNext(first);
        first = node;
    }

    public void insertLast(int data) {
        Node node = new Node();
        node.setData(data);
        if (isEmpty()) {
            first = node;
        } else {
            last.setNext(node);
        }
        node.setPrevious(last);
        last = node;
    }

    public Node deleteFirst() {
        Node temp = first;
        if (first.getNext() == null) {
            last = null;
        } else {
            first.getNext().setPrevious(null);
        }
        first = first.getNext();
        return temp;
    }

    public Node deleteLast() {
        Node temp = last;
        if (first.getNext() == null) {
            first = null;
        } else {
            last.getPrevious().setNext(null);
        }
        last = last.getPrevious();
        return temp;
    }

    public boolean insertAfter(int key, int data) {
        Node current = first;
        while (current.getData() != key) {
            current = current.getNext();
            if (current.getNext() == null)
                return false;
        }

        Node node = new Node();
        node.setData(data);
        if (current == last) {
            current.setNext(node);
            last = node;
        } else {
            node.setNext(current.getNext());
            current.getNext().setPrevious(node);
        }
        node.setPrevious(current);
        current.setNext(node);
        return true;
    }

    public Node deleteAfter(int key) {
        Node current = first;
        while (current.getData() != key) {
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
        Node current = first;
        while (current.getNext() != null) {
            current.displayNode();
            current = current.getNext();

        }
        current.displayNode();
    }

    public void displayBackward() {
        System.out.println(" First <<<====|  Last ");
        Node current = last;
        while (current.getPrevious() != null) {
            current.displayNode();
            current = current.getPrevious();

        }
        current.displayNode();
    }

}
