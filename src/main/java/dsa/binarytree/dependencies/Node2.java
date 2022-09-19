package dsa.binarytree.dependencies;

public class Node2 {
    public int key;
    public String value;
    Node2 leftChild, RightChild;

    public Node2(int key, String value) {
        super();
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node2 getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node2 leftChild) {
        this.leftChild = leftChild;
    }

    public Node2 getRightChild() {
        return RightChild;
    }

    public void setRightChild(Node2 rightChild) {
        RightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value='" + value + '\'' +
                ", leftChild=" + leftChild +
                ", RightChild=" + RightChild +
                '}';
    }
}
