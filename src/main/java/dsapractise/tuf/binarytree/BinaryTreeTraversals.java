package dsapractise.tuf.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Node {

    int data;
    Node left, right, next;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
        next = null;
    }

    // level order traversal using 'next' pointer
    public void printLevelOrder() {
        Node nextLevelRoot = this;
        while (nextLevelRoot != null) {
            Node current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.data + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
};

public class BinaryTreeTraversals {

    // ############################ IN Order Traversal ############################
    static ArrayList<Integer> inOrderIterativeTraversal(Node curr) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while (true) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty())
                    break;
                curr = stack.pop();
                inOrder.add(curr.data);
                // stack.pop();
                curr = curr.right;
            }
        }
        return inOrder;
    }

    static void inOrderRecursiveTraversal(Node curr, ArrayList<Integer> inOrder) {
        if (curr == null)
            return;
        inOrderRecursiveTraversal(curr.left, inOrder);
        inOrder.add(curr.data);
        inOrderRecursiveTraversal(curr.right, inOrder);
    }
    // ############################ PRE Order Traversal ############################

    static ArrayList<Integer> preOrderIterativeTraversal(Node curr) {
        ArrayList<Integer> preOrderList = new ArrayList();
        if (curr == null)
            return preOrderList;
        Stack<Node> stack = new Stack();
        stack.push(curr);
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            preOrderList.add(top.data);
            if (top.right != null)
                stack.push(top.right);
            if (top.left != null)
                stack.push(top.left);
        }
        return preOrderList;
    }

    static void preOrderRecursiveTraversal(Node curr, ArrayList<Integer> preOrderList) {
        if (curr == null)
            return;
        preOrderList.add(curr.data);
        preOrderRecursiveTraversal(curr.left, preOrderList);
        preOrderRecursiveTraversal(curr.right, preOrderList);
    }

    // ############################ POST Order Traversal
    // ############################
    static void postOrderRecursiveTraversal(Node curr, ArrayList<Integer> postOrderList) {
        if (curr == null)
            return;
        postOrderRecursiveTraversal(curr.left, postOrderList);
        postOrderRecursiveTraversal(curr.right, postOrderList);
        postOrderList.add(curr.data);
    }

    static ArrayList<Integer> postOrderTwoStackTraversal(Node curr) {
        ArrayList<Integer> postOrderList = new ArrayList();
        if (curr == null)
            return postOrderList;
        Stack<Node> s1 = new Stack();
        Stack<Node> s2 = new Stack();
        s1.push(curr);
        while (!s1.isEmpty()) {
            curr = s1.pop();
            s2.push(curr);
            if (curr.left != null)
                s1.push(curr.left);
            if (curr.right != null)
                s1.push(curr.right);
        }
        while (!s2.isEmpty()) {
            postOrderList.add(s2.pop().data);
        }
        return postOrderList;
    }

    // ############################ Three Traversals in one method
    // ############################
    class Pair {

        Node node;
        int num;

        Pair(Node _node, int _num) {
            num = _num;
            node = _node;
        }

    }

    void allTraversal(Node root, List<Integer> pre, List<Integer> in, List<Integer> post) {
        Stack<Pair> st = new Stack<Pair>();
        st.push(new Pair(root, 1));
        if (root == null)
            return;
        while (!st.isEmpty()) {
            Pair it = st.pop();
            if (it.num == 1) {
                pre.add(it.node.data);
                it.num++;
                st.push(it);
                if (it.node.left != null) {
                    st.push(new Pair(it.node.left, 1));
                }
            } else if (it.num == 2) {
                in.add(it.node.data);
                it.num++;
                st.push(new Pair(it.node.right, 1));
            } else {
                post.add(it.node.data);
            }
        }
    }
    // ############################ Maximum depth of a Binary Tree
    // ############################

    int depthofTreeIterative(Node root) {
        if (root == null)
            return 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node tempNode = queue.poll();
                if (tempNode.left != null)
                    queue.offer(tempNode.left);
                if (tempNode.right != null)
                    queue.offer(tempNode.right);
            }
        }
        return level;
    }

    int depthOfTreeRecursive(Node root) {
        if (root == null)
            return 0;
        int lh = depthOfTreeRecursive(root.left);
        int rh = depthOfTreeRecursive(root.right);
        return 1 + Math.max(lh, rh);
    }
    // ############################ Check is Binary Tree balanced ??
    // ############################

    static int dfsBalancedRecursive(Node root) {
        if (root == null)
            return 0;
        int lh = dfsBalancedRecursive(root.left);
        if (lh == -1)
            return -1;
        int rh = dfsBalancedRecursive(root.right);
        if (rh == -1)
            return -1;
        if (Math.abs(lh - rh) > 1)
            return -1;
        return Math.max(lh, rh) + 1;
    }

    static boolean isBalancedBinaryTree(Node root) {
        return dfsBalancedRecursive(root) != -1;
    }
    // TODO : UDAY == >iterative Approach dfsHeightIterative <==
    // ############################ Diameter of a Binary Tree
    // ############################

    static int diameterOfBinaryTreeRecursive(Node root, int[] diameter) {
        if (root == null)
            return 0;
        int lh = diameterOfBinaryTreeRecursive(root.left, diameter);
        int rh = diameterOfBinaryTreeRecursive(root.right, diameter);
        diameter[0] = Math.max(lh + rh, diameter[0]);
        return 1 + Math.max(lh, rh);
    }
    // TODO : UDAY == >iterative Approach diameterOfBinaryTreeIterative <==

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
        ArrayList<Integer> inOrder;
        inOrder = inOrderIterativeTraversal(root);
        printBinaryTree(inOrder, "IN_ORDER", "ITERATIVE");
        inOrderRecursiveTraversal(root, inOrder);
        printBinaryTree(inOrder, "IN_ORDER", "RECURSIVE");
        preOrderIterativeTraversal(root);
        printBinaryTree(inOrder, "PRE_ORDER", "ITERATIVE");
        preOrderRecursiveTraversal(root, inOrder);
        printBinaryTree(inOrder, "PRE_ORDER", "RECURSIVE");
        postOrderRecursiveTraversal(root, inOrder);
        printBinaryTree(inOrder, "POST_ORDER", "RECURSIVE");
        postOrderTwoStackTraversal(root);
        printBinaryTree(inOrder, "POST_ORDER_TWO_STACK", "RECURSIVE");
        System.out.println("isBalanced ? ::==> " + isBalancedBinaryTree(root));
    }

    private static void printBinaryTree(ArrayList<Integer> inOrder, String... name) {
        System.out.println("The " + name[0] + " Traversal with Approach " + name[1] + ":  BEGIN");
        for (int i = 0; i < inOrder.size(); i++) {
            System.out.print(inOrder.get(i) + " ");
        }
        System.out.println("");
        System.out.println("The " + name[0] + " Traversal with Approach " + name[1] + ": END ");
    }

}
