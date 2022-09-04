package algorithms.binarysearchtree;

public class Node {
   public  int key;
    String value;
    Node leftChild, RightChild;

    public Node(int key, String value){
       super();
       this.key=key;
       this.value=value;
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

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return RightChild;
    }

    public void setRightChild(Node rightChild) {
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
