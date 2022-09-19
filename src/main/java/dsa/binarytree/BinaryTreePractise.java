package dsa.binarytree;

import dsa.binarytree.dependencies.BinaryTreeNode;
import dsa.binarytree.dependencies.NodeVec;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

// Represents a node of an n-ary tree




public class BinaryTreePractise {

    // Utility function to create a new tree node
    NodeVec newNode(int key) {
        NodeVec temp = new NodeVec();
        temp.key = key;
        temp.child = new Vector<>();
        return temp;
    }

    public void testNonBinaryTreeSum() {
        // Creating a generic tree
        NodeVec root = newNode(20);
        (root.child).add(newNode(2));
        (root.child).add(newNode(34));
        (root.child).add(newNode(50));
        (root.child).add(newNode(60));
        (root.child).add(newNode(70));
        (root.child.get(0).child).add(newNode(15));
        (root.child.get(0).child).add(newNode(20));
        (root.child.get(1).child).add(newNode(30));
        (root.child.get(2).child).add(newNode(40));
        (root.child.get(2).child).add(newNode(100));
        (root.child.get(2).child).add(newNode(20));
        (root.child.get(0).child.get(1).child).add(newNode(25));
        (root.child.get(0).child.get(1).child).add(newNode(50));
    }

    public static void main(String[] args) {
        BinaryTreePractise btp = new BinaryTreePractise();
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.left.left.left = new BinaryTreeNode(6);
        root.left.left.right = new BinaryTreeNode(7);
        root.left.right.left = new BinaryTreeNode(8);
        root.left.right.right = new BinaryTreeNode(9);
        root.right.right = new BinaryTreeNode(11);
        root.right.right.right = new BinaryTreeNode(18);
        System.out.println("printAnscestors : " + btp.printAnscestors(root, root.left.right.right));
    }

    /*
     * : 1) Find Maximum value of an element in a binary tree with recursion
     */
    public int maxInBinaryTree(BinaryTreeNode root) {
        int maxVal = Integer.MIN_VALUE;
        if (root != null) {
            int leftMax = maxInBinaryTree(root.left);
            int rightMax = maxInBinaryTree(root.right);
            maxVal = Math.max(leftMax, rightMax);
            maxVal = Math.max(maxVal, root.data);
            // maxVal = (leftMax >rightMax) ?leftMax : rightMax;
            // maxVal = (root.data > maxVal) ? root.data : maxVal;
        }
        return maxVal;
    }

    /*
     * : 2) Find Maximum value of an element in a binary tree without using
     * recursion
     */
    public int maxInBinaryTreeNonRecursive(BinaryTreeNode root) {
        int maxVal = Integer.MIN_VALUE;
        if (root == null) {
            return maxVal;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            BinaryTreeNode tempNode = q.poll();
            maxVal = Math.max(tempNode.data, maxVal);
            if (tempNode != null) {
                if (tempNode.left != null)
                    q.offer(tempNode.left);
                if (tempNode.right != null)
                    q.offer(tempNode.right);
            }
        }
        return maxVal;
    }

    /*
     * : 3) Search an element in binary tree
     */
    public boolean findElementInBinaryTree(BinaryTreeNode root, int val) {
        if (root == null)
            return false;
        if (root.data == val)
            return true;
        return findElementInBinaryTree(root.right, val) || findElementInBinaryTree(root.left, val);
    }

    /*
     * : 4) Search an element in binary tree without recursion
     */
    public boolean findElementInBinaryTreeNoRecursion(BinaryTreeNode root, int val) {
        if (root == null)
            return false;
        if (root.data == val)
            return true;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            BinaryTreeNode tmpNode = q.poll();
            if (tmpNode.data == val)
                return true;
            else {
                if (tmpNode.left != null)
                    q.offer(tmpNode.left);
                if (tmpNode.right != null)
                    q.offer(tmpNode.right);
            }
        }
        return false;
    }

    /*
     * : 5a) Insert an Element into Binary Tree
     */
    public BinaryTreeNode insertElementInBinaryTree(BinaryTreeNode root, int val) {
        if (root == null)
            return new BinaryTreeNode(val);
        else {
            return insertElementInBinaryTreeHelper(root, val);
        }
    }

    private BinaryTreeNode insertElementInBinaryTreeHelper(BinaryTreeNode root, int val) {
        if (root.data <= val) {
            if (root.right == null) {
                root.right = new BinaryTreeNode(val);
            } else {
                insertElementInBinaryTreeHelper(root.right, val);
            }
        } else {
            if (root.left == null)
                root.left = new BinaryTreeNode(val);
            else
                insertElementInBinaryTreeHelper(root.left, val);
        }
        return root;
    }

    /*
     * : 5b) Insert an Element into Binary Tree No Recursion
     */
    public BinaryTreeNode insertElementInBinaryTreeNoRecursion(BinaryTreeNode root, int val) {
        if (root == null)
            return new BinaryTreeNode(val);
        else {
            Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
            q.offer(root);
            if (!q.isEmpty()) {
                BinaryTreeNode tmpNode = q.poll();
                if (tmpNode.data >= val) {
                    if (tmpNode.left == null)
                        tmpNode.left = new BinaryTreeNode(val);
                    else
                        q.offer(tmpNode.left);
                } else {
                    if (tmpNode.right == null)
                        tmpNode.right = new BinaryTreeNode(val);
                    else
                        q.offer(tmpNode.right);
                }
            }
        }
        return root;
    }

    /*
     * : 6) Find the size of a binaryTree recursive
     */
    public int sizeOfBianryTree(BinaryTreeNode root) {
        int lCount = root.left == null ? 0 : sizeOfBianryTree(root.left);
        int rCount = root.right == null ? 0 : sizeOfBianryTree(root.right);
        return 1 + lCount + rCount;
    }

    /*
     * : 7) Find the size of a binaryTree without recursion
     */
    public int sizeOfBianryTreeNonRecursive(BinaryTreeNode root) {
        int count = 0;
        if (root == null)
            return 0;
        else {
            Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
            q.offer(root);
            while (!q.isEmpty()) {
                BinaryTreeNode tmpNode = q.poll();
                count++;
                if (tmpNode.left != null) {
                    q.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    q.offer(tmpNode.right);
                }
            }
        }
        return count;
    }

    /*
     * : 8) Delete Binary Tree
     */
    public void deleteOfBianryTree(BinaryTreeNode root) {
        root = null;
    }

    /*
     * : 9) Delete Binary Tree
     */
    public void printReverseBianryTree(BinaryTreeNode root) {
        if (root != null) {
            printReverseBianryTree(root.left);
            printReverseBianryTree(root.right);
            System.out.println(root.data);
        }
    }

    /*
     * : 20) Diameter of tree
     */
    public int diameterTree(BinaryTreeNode root) {
        if (root == null)
            return 0;
        int left, right, diameter = 0;
        left = diameterTree(root.left);
        right = diameterTree(root.right);
        if (left + right > diameter)
            diameter = left + right;
        return Math.max(left, right + 1);
    }

    /*
     * : 32) Print all ancestors
     */
    public boolean printAnscestors(BinaryTreeNode root, BinaryTreeNode node) {
        if (root == null)
            return false;
        if (root.right == node || root.left == node || printAnscestors(root.left, node)
                || printAnscestors(root.right, node)) {
            System.out.println(root.data);
            return true;
        }
        return false;
    }

    public int sumNodesNonRecursive(NodeVec root) {
        // initialize the sum variable
        int sum = 0;
        if (root == null)
            return 0;
        // Creating a queue and pushing the root
        Queue<NodeVec> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            // If this node has children
            while (n > 0) {
                // Dequeue an item from queue and
                // add it to variable "sum"
                NodeVec p = q.peek();
                q.remove();
                sum += p.key;
                // Enqueue all children of the dequeued item
                for (int i = 0; i < p.child.size(); i++)
                    q.add(p.child.get(i));
                n--;
            }
        }
        return sum;
    }

}
