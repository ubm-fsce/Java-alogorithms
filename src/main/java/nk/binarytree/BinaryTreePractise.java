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

    public static void main(String[] args) {
        BinaryTreePractise btp = new BinaryTreePractise();
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.left.left.left = new BinaryTreeNode(6);
        System.out.println(btp.sizeOfBianryTreeNonRecursive(root));
    }

    /*
        TODO:  1) Find Maximum value of an element in a binary tree with recursion
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
         TODO: 2) Find Maximum value of an element in a binary tree without using recursion
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
         TODO: 3) Search an element in binary tree
     */
    public boolean findElementInBinaryTree(BinaryTreeNode root, int val) {
        if (root == null)
            return false;
        if (root.data == val)
            return true;
        return findElementInBinaryTree(root.right, val) || findElementInBinaryTree(root.left, val);
    }

    /*
      TODO: 4) Search an element in binary tree without recursion
  */
    public boolean findElementInBinaryTreeNoRecursion(BinaryTreeNode root, int val) {
        if (root == null)
            return false;
        if (root.data == val) return true;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            BinaryTreeNode tmpNode = q.poll();
            if (tmpNode.data == val) return true;
            else {
                if (tmpNode.left != null) q.offer(tmpNode.left);
                if (tmpNode.right != null) q.offer(tmpNode.right);
            }
        }
        return false;
    }

    /*
   TODO: 5a) Insert an Element into Binary Tree
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
 TODO: 5b) Insert an Element into Binary Tree No Recursion
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
TODO:  6) Find the size of a binaryTree recursive
*/
    public int sizeOfBianryTree(BinaryTreeNode root) {
        int lCount = root.left == null ? 0 : sizeOfBianryTree(root.left);
        int rCount = root.right == null ? 0 : sizeOfBianryTree(root.right);
        return 1 + lCount + rCount;
    }

    /*
TODO:  7) Find the size of a binaryTree without recursion
*/
    public int sizeOfBianryTreeNonRecursive(BinaryTreeNode root) {
        int count = 0;
        if (root == null) return 0;
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
       TODO:  8) Delete Binary Tree
*/
    public void deleteOfBianryTree(BinaryTreeNode root) {
        root = null;
    }

    /*
       TODO:  9) Delete Binary Tree
*/
    public void deleteOfBianryTree(BinaryTreeNode root) {
        root = null;
    }


}



