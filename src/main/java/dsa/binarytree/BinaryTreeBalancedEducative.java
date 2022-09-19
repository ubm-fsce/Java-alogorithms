package dsa.binarytree;

import dsa.dependencies.TreeNode;

class BinaryTreeBalanced {
    TreeNode root;

    /* Returns true if binary tree with root as root is height-balanced */
    boolean isBalanced(TreeNode TreeNode) {
        int lh; /* for height of left subtree */

        int rh; /* for height of right subtree */

        /* If tree is empty then return true */
        if (TreeNode == null)
            return true;

        /* Get the height of left and right sub trees */
        lh = height(TreeNode.left);
        rh = height(TreeNode.right);

        if (Math.abs(lh - rh) <= 1
                && isBalanced(TreeNode.left)
                && isBalanced(TreeNode.right))
            return true;

        /* If we reach here then tree is not height-balanced */
        return false;
    }

    /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
    /*
     * The function Compute the "height" of a tree. Height is the
     * number of TreeNodes along the longest path from the root TreeNode
     * down to the farthest leaf TreeNode.
     */
    int height(TreeNode TreeNode) {
        /* base case tree is empty */
        if (TreeNode == null)
            return 0;

        /*
         * If tree is not empty then height = 1 + max of left
         * height and right heights
         */
        return 1 + Math.max(height(TreeNode.left), height(TreeNode.right));
    }

    public static void main(String args[]) {
        BinaryTreeBalanced tree = new BinaryTreeBalanced();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.left.left.left = new TreeNode(8);

        if (tree.isBalanced(tree.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}
