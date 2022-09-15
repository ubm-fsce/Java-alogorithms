package dsabasics.algorirhms.binarysearchtree;

public class BinarySearchTree {
    private Node root;

    public void insert(int key, String value) {
        Node newNode = new Node(key, value);
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
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

    public Node findMinNode() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.getLeftChild();
        }
        return last;
    }

    public Node findMaxNode() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.getRightChild();
        }
        return last;
    }

}
