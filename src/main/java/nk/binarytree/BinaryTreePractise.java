package nk.binarytree;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeNode {
    int data;
    BinaryTreeNode left, right;
    BinaryTreeNode(int d) {
        data = d;
        left = right = null;
    }

}

public class BinaryTreePractise {

    /*
        1) Find Maximum value of an element in a binary tree with recursion
    */
    public int maxInBinaryTree(BinaryTreeNode root) {
        int maxVal = Integer.MIN_VALUE;
        if (root != null) {
            int leftMax = maxInBinaryTree(root.left);
            int rightMax = maxInBinaryTree(root.right);
            maxVal = Math.max(leftMax, rightMax);
            maxVal = Math.max(maxVal, root.data);
            //maxVal = (leftMax >rightMax) ?leftMax : rightMax;
            //maxVal = (root.data > maxVal) ? root.data : maxVal;
        }
        return maxVal;
    }

    /*
         2) Find Maximum value of an element in a binary tree without using recursion
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
         3) Search an element in binary tree
     */
    public boolean findElementInBinaryTree(BinaryTreeNode root, int val) {
    if(root==null)
        return  false;
    if(root.data==val)
        return  true;
    return findElementInBinaryTree(root.right, val) || findElementInBinaryTree(root.left, val);

    }

}



