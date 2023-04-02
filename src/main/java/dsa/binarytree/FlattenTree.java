package dsa.binarytree;

import dsa.dependencies.BinaryTreeNode;

public class FlattenTree {
  public static BinaryTreeNode flattenTree(BinaryTreeNode root) {
    // Write your code here
    BinaryTreeNode tempNode = new BinaryTreeNode(0);
    dfs(root, tempNode);
    return tempNode;
  }

  public static void dfs(BinaryTreeNode node, BinaryTreeNode tempNode) {
    if (node != null) {
      tempNode.next = node;
    }
    if (node.left != null) {
      dfs(node.left, tempNode);
    }
    if (node.right != null) {
      dfs(node.right, tempNode);
    }

  }
}