package dsa.binarytree.dependencies;

public
class Node {

    public int data;
    public Node left, right, next;

   public  Node(int data) {
        this.data = data;
        left = null;
        right = null;
        next = null;
    }

}
