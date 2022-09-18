package dsapractise.tuf.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

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
        ArrayList<Integer> preOrderList = new ArrayList<>();
        if (curr == null)
            return preOrderList;
        Stack<Node> stack = new Stack<>();
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
        ArrayList<Integer> postOrderList = new ArrayList<>();
        if (curr == null)
            return postOrderList;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
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
    // : UDAY == >iterative Approach dfsHeightIterative <==
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
    // : UDAY == >iterative Approach diameterOfBinaryTreeIterative <==

    // ############################ Maximum Path sum of a binary tree

    static int maxPathSumRecursive(Node root, int[] maxPathSum) {
        if (root == null)
            return 0;
        int lsum = Math.max(Integer.MIN_VALUE, maxPathSumRecursive(root.left, maxPathSum));
        int rSum = Math.max(Integer.MIN_VALUE, maxPathSumRecursive(root.right, maxPathSum));
        maxPathSum[0] = Math.max(maxPathSum[0], (root.data + lsum + rSum));
        return Math.max(lsum, rSum) + root.data;
    }

    public static int maxPathSum(Node root) {
        int maxpathsumArray[] = { Integer.MIN_VALUE };
        maxPathSumRecursive(root, maxpathsumArray);
        return maxpathsumArray[0];
    }

    // ############################ Check if two trees are identical

    static boolean check(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.data != root2.data)
            return false;

        return true;
    }

    // https://leetcode.com/problems/same-tree/solution/
    static boolean isIdenticalTreesIterative(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (!check(root1, root2))
            return false;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.offer(root1);
        q2.offer(root2);
        while (!q1.isEmpty()) {
            Node r1n = null, r2n = null;
            r1n = q1.poll();
            r2n = q2.poll();

            if (!check(r1n, r2n))
                return false;
            if (!check(r1n.left, r2n.left))
                return false;
            if (r1n != null) {
                if (r1n.left != null) {
                    q1.offer(r1n.left);
                    q2.offer(r2n.left);

                }
                if (!check(r1n.right, r2n.right))
                    return false;
                if (r1n.right != null) {
                    q1.offer(r1n.right);
                    q2.offer(r2n.right);

                }
            }
        }
        return true;
    }

    static boolean isIdenticalTreesRecursive(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return isIdenticalTreesRecursive(root1.left, root2.left) &&
                isIdenticalTreesRecursive(root1.right, root2.right) && root1.data == root2.data;
    }

    // ############################ ZIGZAG Traversal

    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        boolean flip = false;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> sublist = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                if (q.peek().left != null)
                    q.offer(q.peek().left);
                if (q.peek().right != null)
                    q.offer(q.peek().right);
                if (flip == true)
                    sublist.add(q.poll().data);
                else
                    sublist.add(0, q.poll().data);

            }
            flip = !flip;
            result.add(sublist);
        }
        return result;

    }

    // ############################ Vertical Orde Traversal iterative
    class Tuple {
        Node node;
        int row;
        int column;

        public Tuple(Node n, int r, int c) {
            this.node = n;
            this.row = r;
            this.column = c;
        }
    }

    List<List<Integer>> verticalOrderTraversalIterative(Node root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treemap = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            Node node = t.node;
            int r = t.row;
            int c = t.column;
            if (!treemap.containsKey(r)) {
                treemap.put(r, new TreeMap<>());
            }
            if (!treemap.get(r).containsKey(c)) {
                treemap.get(r).put(c, new PriorityQueue<Integer>());
            }
            treemap.get(r).get(c).offer(node.data);
            if (node.left != null) {
                q.offer(new Tuple(node.left, r - 1, c + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, r + 1, c + 1));

            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : treemap.values()) {
            list.add(new ArrayList<Integer>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }

    // ############################ Vertical Orde Traversal Recursive
    // static List<List<Integer>> verticalOrderTraversalRecursvie(Node root) {
    // TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treemap = new
    // TreeMap<>();
    // }

    // private static void dfsVerticalOrderTraversal(Node node, Integer row, Integer
    // col,
    // TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treemap) {

    // if (node == null)
    // return;
    // TreeMap.add(row, new Tuple(node, row, col));

    // }
    // ############################ Top Orde Traversal Iterative
    static List<Integer> topView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int hd = p
        }

    }

    // ############################ Plumbing Code
    public static void main(String args[]) {

        Node root = getTree();
        Node root1 = new Node(1);
        root1.left = new Node(2);
        Node root2 = new Node(1);
        root1.right = new Node(2);
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
        System.out.println("maxPathSum ? ::==> " + maxPathSum(root));

        System.out.println("isIdenticalTreesIterative ? ::==> " +
                isIdenticalTreesIterative(root1, root2));
        System.out.println("isIdenticalTreesRecursive ? ::==> " +
                isIdenticalTreesRecursive(root, getTree()));
        System.out.println("zigzagLevelOrder ? ::==> " + zigzagLevelOrder(root));
        BinaryTreeTraversals bts = new BinaryTreeTraversals();

        System.out.println("verticalOrderTraversalIterative ? ::==> " + bts.verticalOrderTraversalIterative(root));
        System.out.println("UDAY ====>");
    }

    private static void printBinaryTree(ArrayList<Integer> inOrder, String... name) {
        System.out.println("The " + name[0] + " Traversal with Approach " + name[1] + ":  BEGIN");
        for (int i = 0; i < inOrder.size(); i++) {
            System.out.print(inOrder.get(i) + " ");
        }
        System.out.println("");
        System.out.println("The " + name[0] + " Traversal with Approach " + name[1] + ": END ");
    }

    static Node getTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.left = new Node(9);
        root.right.right = new Node(10);

        return root;
    }

}
