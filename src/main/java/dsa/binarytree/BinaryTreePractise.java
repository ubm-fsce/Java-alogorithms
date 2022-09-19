package dsa.binarytree;

import dsa.dependencies.NodeVec;
import dsa.dependencies.TreeNode;

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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.right.right = new TreeNode(11);
        root.right.right.right = new TreeNode(18);
        System.out.println("printAnscestors : " + btp.printAnscestors(root, root.left.right.right));
    }

    /*
     * : 1) Find Maximum value of an element in a binary tree with recursion
     */
    public int maxInBinaryTree(TreeNode root) {
        int maxVal = Integer.MIN_VALUE;
        if (root != null) {
            int leftMax = maxInBinaryTree(root.left);
            int rightMax = maxInBinaryTree(root.right);
            maxVal = Math.max(leftMax, rightMax);
            maxVal = Math.max(maxVal, root.val);
            // maxVal = (leftMax >rightMax) ?leftMax : rightMax;
            // maxVal = (root.data > maxVal) ? root.data : maxVal;
        }
        return maxVal;
    }

    /*
     * : 2) Find Maximum value of an element in a binary tree without using
     * recursion
     */
    public int maxInBinaryTreeNonRecursive(TreeNode root) {
        int maxVal = Integer.MIN_VALUE;
        if (root == null) {
            return maxVal;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode tempNode = q.poll();
            maxVal = Math.max(tempNode.val, maxVal);
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
    public boolean findElementInBinaryTree(TreeNode root, int val) {
        if (root == null)
            return false;
        if (root.val == val)
            return true;
        return findElementInBinaryTree(root.right, val) || findElementInBinaryTree(root.left, val);
    }

    /*
     * : 4) Search an element in binary tree without recursion
     */
    public boolean findElementInBinaryTreeNoRecursion(TreeNode root, int val) {
        if (root == null)
            return false;
        if (root.val == val)
            return true;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode tmpNode = q.poll();
            if (tmpNode.val == val)
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
    public TreeNode insertElementInBinaryTree(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        else {
            return insertElementInBinaryTreeHelper(root, val);
        }
    }

    private TreeNode insertElementInBinaryTreeHelper(TreeNode root, int val) {
        if (root.val <= val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertElementInBinaryTreeHelper(root.right, val);
            }
        } else {
            if (root.left == null)
                root.left = new TreeNode(val);
            else
                insertElementInBinaryTreeHelper(root.left, val);
        }
        return root;
    }

    /*
     * : 5b) Insert an Element into Binary Tree No Recursion
     */
    public TreeNode insertElementInBinaryTreeNoRecursion(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        else {
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.offer(root);
            if (!q.isEmpty()) {
                TreeNode tmpNode = q.poll();
                if (tmpNode.val >= val) {
                    if (tmpNode.left == null)
                        tmpNode.left = new TreeNode(val);
                    else
                        q.offer(tmpNode.left);
                } else {
                    if (tmpNode.right == null)
                        tmpNode.right = new TreeNode(val);
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
    public int sizeOfBianryTree(TreeNode root) {
        int lCount = root.left == null ? 0 : sizeOfBianryTree(root.left);
        int rCount = root.right == null ? 0 : sizeOfBianryTree(root.right);
        return 1 + lCount + rCount;
    }

    /*
     * : 7) Find the size of a binaryTree without recursion
     */
    public int sizeOfBianryTreeNonRecursive(TreeNode root) {
        int count = 0;
        if (root == null)
            return 0;
        else {
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.offer(root);
            while (!q.isEmpty()) {
                TreeNode tmpNode = q.poll();
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
    public void deleteOfBianryTree(TreeNode root) {
        root = null;
    }

    /*
     * : 9) Delete Binary Tree
     */
    public void printReverseBianryTree(TreeNode root) {
        if (root != null) {
            printReverseBianryTree(root.left);
            printReverseBianryTree(root.right);
            System.out.println(root.val);
        }
    }

    /*
     * : 20) Diameter of tree
     */
    public int diameterTree(TreeNode root) {
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
    public boolean printAnscestors(TreeNode root, TreeNode node) {
        if (root == null)
            return false;
        if (root.right == node || root.left == node || printAnscestors(root.left, node)
                || printAnscestors(root.right, node)) {
            System.out.println(root.val);
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
