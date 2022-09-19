package dsa.binarytree;

import dsa.dependencies.TreeNode;

public class BinarySearchTree {

    private TreeNode root;

    public void insert(int key, String val) {
        TreeNode newTreeNode = new TreeNode(key, val);
        if (root == null)
            root = newTreeNode;
        else {
            TreeNode current = root;
            TreeNode parent;
            while (true) {
                parent = current;
                if (key < current.key) {
                    current = current.left;
                    if (current == null) { // it's parent is leafTreeNode
                        parent.left=(newTreeNode);
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right=(newTreeNode);
                        return;
                    }
                }
            }
        }
    }

    public TreeNode findMinTreeNode() {
        TreeNode current = root;
        TreeNode last = null;
        while (current != null) {
            last = current;
            current = current.left;
        }
        return last;
    }

    public TreeNode findMaxTreeNode() {
        TreeNode current = root;
        TreeNode last = null;
        while (current != null) {
            last = current;
            current = current.right;
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
        System.out.println(binarySearchTree.findMaxTreeNode());
        System.out.println(binarySearchTree.findMinTreeNode());
    }

}
