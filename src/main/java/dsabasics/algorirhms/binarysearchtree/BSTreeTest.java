package dsabasics.algorirhms.binarysearchtree;

public class BSTreeTest {
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
