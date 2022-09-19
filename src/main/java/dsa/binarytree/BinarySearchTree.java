package dsa.binarytree;

import dsa.binarytree.dependencies.Node2;

public class BinarySearchTree {

    private Node2 root;

    public void insert(int key, String value) {
        Node2 newNode = new Node2(key, value);
        if (root == null)
            root = newNode;
        else {
            Node2 current = root;
            Node2 parent;
            while (true) {
                parent = current;
                if (key < current.getKey()) {
                    current = current.getLeftChild();
                    if (current == null) { // it's parent is leafNode
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public Node2 findMinNode() {
        Node2 current = root;
        Node2 last = null;
        while (current != null) {
            last = current;
            current = current.getLeftChild();
        }
        return last;
    }

    public Node2 findMaxNode() {
        Node2 current = root;
        Node2 last = null;
        while (current != null) {
            last = current;
            current = current.getRightChild();
        }
        return last;
    }

    // Plubmbing Code
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10, "Ten");
        binarySearchTree.insert(5, "Five");
        binarySearchTree.insert(15, "Fifteen");
        binarySearchTree.insert(12, "Twelve");
        binarySearchTree.insert(25, "Twenty five");
        binarySearchTree.insert(6, "Six");
        System.out.println(binarySearchTree.findMaxNode());
        System.out.println(binarySearchTree.findMinNode());
    }

}
