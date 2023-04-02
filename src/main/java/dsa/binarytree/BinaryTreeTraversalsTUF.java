package dsa.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import dsa.dependencies.TreeNode;

public class BinaryTreeTraversalsTUF {

    // ############################ IN Order Traversal ############################
    static ArrayList<Integer> inOrderIterativeTraversal(TreeNode curr) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty())
                    break;
                curr = stack.pop();
                inOrder.add(curr.val);
                // stack.pop();
                curr = curr.right;
            }
        }
        return inOrder;
    }

    static void inOrderRecursiveTraversal(TreeNode curr, ArrayList<Integer> inOrder) {
        if (curr == null)
            return;
        inOrderRecursiveTraversal(curr.left, inOrder);
        inOrder.add(curr.val);
        inOrderRecursiveTraversal(curr.right, inOrder);
    }
    // ############################ PRE Order Traversal ############################

    static ArrayList<Integer> preOrderIterativeTraversal(TreeNode curr) {
        ArrayList<Integer> preOrderList = new ArrayList<>();
        if (curr == null)
            return preOrderList;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(curr);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            preOrderList.add(top.val);
            if (top.right != null)
                stack.push(top.right);
            if (top.left != null)
                stack.push(top.left);
        }
        return preOrderList;
    }

    static void preOrderRecursiveTraversal(TreeNode curr, ArrayList<Integer> preOrderList) {
        if (curr == null)
            return;
        preOrderList.add(curr.val);
        preOrderRecursiveTraversal(curr.left, preOrderList);
        preOrderRecursiveTraversal(curr.right, preOrderList);
    }
    // ############################ POST Order Traversal

    static void postOrderRecursiveTraversal(TreeNode curr, ArrayList<Integer> postOrderList) {
        if (curr == null)
            return;
        postOrderRecursiveTraversal(curr.left, postOrderList);
        postOrderRecursiveTraversal(curr.right, postOrderList);
        postOrderList.add(curr.val);
    }

    static ArrayList<Integer> postOrderTwoStackTraversal(TreeNode curr) {
        ArrayList<Integer> postOrderList = new ArrayList<>();
        if (curr == null)
            return postOrderList;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
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
            postOrderList.add(s2.pop().val);
        }
        return postOrderList;
    }
    // ############################ Three Traversals in one method

    static class Pair {

        TreeNode TreeNode;
        Integer num;

        Pair(TreeNode _TreeNode, int _num) {
            num = _num;
            TreeNode = _TreeNode;
        }

    }

    void allTraversal(TreeNode root, List<Integer> pre, List<Integer> in, List<Integer> post) {
        Stack<Pair> st = new Stack<Pair>();
        st.push(new Pair(root, 1));
        if (root == null)
            return;
        while (!st.isEmpty()) {
            Pair it = st.pop();
            if (it.num == 1) {
                pre.add(it.TreeNode.val);
                it.num++;
                st.push(it);
                if (it.TreeNode.left != null) {
                    st.push(new Pair(it.TreeNode.left, 1));
                }
            } else if (it.num == 2) {
                in.add(it.TreeNode.val);
                it.num++;
                st.push(it);
                st.push(new Pair(it.TreeNode.right, 1));
            } else {
                post.add(it.TreeNode.val);
            }
        }
    }
    // ############################ Maximum depth of a Binary Tree

    int maxDepthofTreeIterative(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tempTreeNode = queue.poll();
                if (tempTreeNode.left != null)
                    queue.offer(tempTreeNode.left);
                if (tempTreeNode.right != null)
                    queue.offer(tempTreeNode.right);
            }
        }
        return level;
    }

    int maxDepthOfTreeRecursive(TreeNode root) {
        if (root == null)
            return 0;
        int lh = maxDepthOfTreeRecursive(root.left);
        int rh = maxDepthOfTreeRecursive(root.right);
        return 1 + Math.max(lh, rh);
    }
    // ############################ Check is Binary Tree balanced ??

    static int dfsBalancedRecursive(TreeNode root) {
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

    static boolean isBalancedBinaryTree(TreeNode root) {
        return dfsBalancedRecursive(root) != -1;
    }
    // : UDAY == >iterative Approach dfsHeightIterative <==
    // ############################ Diameter of a Binary Tree

    static int diameterOfBinaryTreeRecursive(TreeNode root, int[] diameter) {
        if (root == null)
            return 0;
        int lh = diameterOfBinaryTreeRecursive(root.left, diameter);
        int rh = diameterOfBinaryTreeRecursive(root.right, diameter);
        diameter[0] = Math.max(lh + rh, diameter[0]);
        return 1 + Math.max(lh, rh);
    }
    // : UDAY == >iterative Approach diameterOfBinaryTreeIterative <==
    // ############################ Maximum Path sum of a binary tree

    static int maxPathSumRecursive(TreeNode root, int[] maxPathSum) {
        if (root == null)
            return 0;
        int lsum = Math.max(Integer.MIN_VALUE, maxPathSumRecursive(root.left, maxPathSum));
        int rSum = Math.max(Integer.MIN_VALUE, maxPathSumRecursive(root.right, maxPathSum));
        maxPathSum[0] = Math.max(maxPathSum[0], (root.val + lsum + rSum));
        return Math.max(lsum, rSum) + root.val;
    }

    public static int maxPathSum(TreeNode root) {
        int maxpathsumArray[] = { Integer.MIN_VALUE };
        maxPathSumRecursive(root, maxpathsumArray);
        return maxpathsumArray[0];
    }
    // ############################ Check if two trees are identical

    static boolean check(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return true;
    }

    // https://leetcode.com/problems/same-tree/solution/
    static boolean isIdenticalTreesIterative(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (!check(root1, root2))
            return false;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root1);
        q2.offer(root2);
        while (!q1.isEmpty()) {
            TreeNode r1n = null, r2n = null;
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

    static boolean isIdenticalTreesRecursive(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return isIdenticalTreesRecursive(root1.left, root2.left) &&
                isIdenticalTreesRecursive(root1.right, root2.right) && root1.val == root2.val;
    }
    // ############################ ZIGZAG Traversal

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
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
                    sublist.add(q.poll().val);
                else
                    sublist.add(0, q.poll().val);
            }
            flip = !flip;
            result.add(sublist);
        }
        return result;
    }

    // ############################ Vertical Orde Traversal iterative
    class Tuple {

        TreeNode TreeNode;
        int row;
        int column;

        public Tuple(TreeNode n, int r, int c) {
            this.TreeNode = n;
            this.row = r;
            this.column = c;
        }

    }

    List<List<Integer>> verticalOrderTraversalIterative(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treemap = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode TreeNode = tuple.TreeNode;
            int r = tuple.row;
            int c = tuple.column;
            if (!treemap.containsKey(r)) {
                treemap.put(r, new TreeMap<>());
            }
            if (!treemap.get(r).containsKey(c)) {
                treemap.get(r).put(c, new PriorityQueue<Integer>());
            }
            treemap.get(r).get(c).offer(TreeNode.val);
            if (TreeNode.left != null) {
                q.offer(new Tuple(TreeNode.left, r - 1, c + 1));
            }
            if (TreeNode.right != null) {
                q.offer(new Tuple(TreeNode.right, r + 1, c + 1));
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : treemap.values()) {
            list.add(new ArrayList<Integer>());
            for (PriorityQueue<Integer> TreeNodes : ys.values()) {
                while (!TreeNodes.isEmpty()) {
                    list.get(list.size() - 1).add(TreeNodes.poll());
                }
            }
        }
        return list;
    }
    // ############################ Vertical Orde Traversal Recursive
    // static List<List<Integer>> verticalOrderTraversalRecursvie(TreeNode root) {
    // TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treemap = new
    // TreeMap<>();
    // }
    // private static void dfsVerticalOrderTraversal(TreeNode TreeNode, Integer row,
    // Integer
    // col,
    // TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treemap) {
    // if (TreeNode == null)
    // return;
    // TreeMap.add(row, new Tuple(TreeNode, row, col));

    // }
    // ############################ Top View Traversal Iterative
    static List<Integer> topViewIterative(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int hd = p.num;
            TreeNode TreeNode = p.TreeNode;
            // we are retaining first inserted values here so top valus are retained in map
            // this helps to get top view
            if (map.get(hd) == null)
                map.put(hd, TreeNode.val);
            if (TreeNode.left != null) {
                q.add(new Pair(TreeNode.left, hd - 1));
            }
            if (TreeNode.right != null) {
                q.add(new Pair(TreeNode.right, hd + 1));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
    // ############################ Bottom View Traversal Iterative

    static List<Integer> bottomViewIterative(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int hd = p.num;
            TreeNode TreeNode = p.TreeNode;
            // Note : we are OVerwriting the valus in map so first inserted values are
            // getting overridden so that bottom view values are retained.
            map.put(hd, TreeNode.val);
            if (TreeNode.left != null) {
                q.offer(new Pair(TreeNode.left, hd - 1));
            }
            if (TreeNode.right != null) {
                q.offer(new Pair(TreeNode.right, hd + 1));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }

    // ############################ Symmetric Tree Recursive
    public boolean isSymmetricRecursive(TreeNode root) {
        return symmetricUtil(root.left, root.right);
    }

    static boolean symmetricUtil(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return (root1.val == root2.val) && symmetricUtil(root1.left, root2.right)
                && symmetricUtil(root2.left, root1.right);
    }

    // ############################ Symmetric Tree Iterative
    public boolean isSymmetricIterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode tn1 = q.poll();
            TreeNode tn2 = q.poll();
            if (tn1 == null && tn2 == null)
                continue;
            if (tn1 == null || tn2 == null)
                return false;
            if (tn1.val != tn2.val)
                return false;
            q.add(tn1.left);
            q.add(tn2.right);
            q.add(tn1.right);
            q.add(tn2.left);
        }
        return true;
    }
    // ############################ Right View of a Binary Tree Recursive

    public List<Integer> rightSideViewRecursive(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        rvRecursive(root, 0, res);
        return res;
    }

    static void rvRecursive(TreeNode root, Integer currDepth, List<Integer> res) {
        if (root == null)
            return;
        // left or right capturing the element at size = depth:)
        if (currDepth == res.size()) {
            res.add(root.val);
        }
        // to be noted here call recursively right and left for right view
        rvRecursive(root.right, currDepth + 1, res);
        rvRecursive(root.left, currDepth + 1, res);
    }

    // ############################ Right View of a Binary Tree Iterative
    public List<Integer> rightSideViewItertaive(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();

                q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
                // right view capture at size-1
                if (i == (size - 1)) {
                    list.add(temp.val);
                }
            }
        }
        return list;
    }
    // ############################ Left View of a Binary Tree Recursive

    public List<Integer> leftSideViewRecursive(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        leftvRecursive(root, 0, res);
        return res;
    }

    static void leftvRecursive(TreeNode root, Integer currDepth, List<Integer> res) {
        if (root == null)
            return;
        // left or right capturing the element at size = depth:)
        if (currDepth == res.size()) {
            res.add(root.val);
        }
        // to be noted here call recursively left and right for left view
        leftvRecursive(root.left, currDepth + 1, res);
        leftvRecursive(root.right, currDepth + 1, res);
    }

    // ############################ Right View of a Binary Tree Iterative
    public List<Integer> leftSideViewItertaive(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
                // left view capture at 0 or beginning
                if (i == (0)) {
                    list.add(temp.val);
                }
            }
        }
        return list;
    }

    // ############################ Print root to node path
    static List<Integer> root2nodePath(TreeNode root, int nodeVal) {
        List<Integer> list = new ArrayList<>();
        r2nRecursive(root, nodeVal, list);
        return list;
    }

    static boolean r2nRecursive(TreeNode node, int nodeVal, List<Integer> list) {
        if (node == null)
            return false;
        list.add(node.val);
        if (node.val == nodeVal)
            return true;
        if (r2nRecursive(node.left, nodeVal, list) || r2nRecursive(node.right, nodeVal, list))
            return true;
        list.remove(list.size() - 1);
        return false;
    }

    static TreeNode lCARecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lCARecursive(root.left, p, q);
        TreeNode right = lCARecursive(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    private static TreeNode ans = null;

    static TreeNode getAnsforlCARecursive2(TreeNode currentNode, TreeNode p, TreeNode q) {
        lCARecursive2(currentNode, p, q);
        return ans;
    }

    static boolean lCARecursive2(TreeNode currentNode, TreeNode p, TreeNode q) {
        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }
        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = lCARecursive2(currentNode.left, p, q) ? 1 : 0;
        // Right Recursion
        int right = lCARecursive2(currentNode.right, p, q) ? 1 : 0;
        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            ans = currentNode;
        }
        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    // ############################ Print all nodes at a distance K in Binary Tree
    private static void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                parent_track.put(curr.left, curr);
                q.offer(curr.left);
            }
            if (curr.right != null) {
                parent_track.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }

    public static List<Integer> NodesAtdistanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(root, parent_track);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (curr_level == k)
                break;
            curr_level++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null && visited.get(curr.left) == null) {
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                }
                if (curr.right != null && visited.get(curr.right) == null) {
                    q.offer(curr.right);
                    visited.put(curr.right, true);
                }
                if (parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null) {
                    q.offer(parent_track.get(curr));
                    visited.put(parent_track.get(curr), true);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            res.add(curr.val);
        }
        return res;
    }

    // ############################ Print all nodes at a distance K in Binary Tree
    // Version 2
    private static void markParentsv2(TreeNode root, TreeNode par, Map<TreeNode, TreeNode> parent_track) {
        if (root != null) {
            parent_track.put(root, par);
            markParentsv2(root.left, root, parent_track);
            markParentsv2(root.right, root, parent_track);
        }
    }

    public static List<Integer> NodesAtdistanceKV2(TreeNode root, TreeNode target, int K) {
        String str = "";

        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParentsv2(root, null, parent_track);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(target);
        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);
        seen.add(null);
        int dist = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (dist == K) {
                    List<Integer> ans = new ArrayList<>();
                    for (TreeNode n : queue)
                        ans.add(n.val);
                    return ans;
                }
                queue.offer(null);
                dist++;
            } else {
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = parent_track.get(node);
                if (!seen.contains(par)) {
                    seen.add(par);
                    queue.offer(par);
                }
            }
        }
        return new ArrayList<Integer>();
    }
    // ############################ Print all nodes at a distance K in Binary Tree
    // Version 3

    public static List<Integer> NodesAtdistanceKV3(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new LinkedList<>();
        dfs(root, target, k, ans);
        return ans;
    }

    // Return vertex distance from node to target if exists, else -1
    // Vertex distance: the number of vertices on the path from node to target
    public static int dfs(TreeNode node, TreeNode target, int k, List<Integer> ans) {
        if (node == null)
            return -1;
        else if (node == target) {
            subtree_add(node, 0, k, ans);
            return 1;
        } else {
            int L = dfs(node.left, target, k, ans), R = dfs(node.right, target, k, ans);
            if (L != -1) {
                if (L == k)
                    ans.add(node.val);
                subtree_add(node.right, L + 1, k, ans);
                return L + 1;
            } else if (R != -1) {
                if (R == k)
                    ans.add(node.val);
                subtree_add(node.left, R + 1, k, ans);
                return R + 1;
            } else {
                return -1;
            }
        }
    }

    // Add all nodes 'K - dist' from the node to answer.
    public static void subtree_add(TreeNode node, int dist, int k, List<Integer> ans) {
        if (node == null)
            return;
        if (dist == k)
            ans.add(node.val);
        else {
            subtree_add(node.left, dist + 1, k, ans);
            subtree_add(node.right, dist + 1, k, ans);
        }
    }
    // ###### Minimum time taken to BURN the Binary tree from a Node

    /* Yet to complete */

    // ###### Count total nodes in a complete Binary Tree recursive

    static void inOrderTravRecusrise(TreeNode curr, int count[]) {
        if (curr == null)
            return;
        count[0]++;
        inOrderTravRecusrise(curr.left, count);
        inOrderTravRecusrise(curr.right, count);
    }

    // ###### Count total nodes in a complete Binary Tree ITERATIVE
    public int getRightHeight(TreeNode root) {
        int count = 0;
        TreeNode curr = root;
        while (curr.right != null) {
            count++;
            curr = curr.right;
        }
        return count;
    }

    public int getLeftHeight(TreeNode root) {
        int count = 0;
        TreeNode curr = root;
        while (curr.left != null) {
            count++;
            curr = curr.left;
        }
        return count;
    }

    public int countNodesinCompleteBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);
        if (lh == rh) {
            return (1 << lh) - 1; // This is nothing but 1*(2^h)-1
        }
        int leftNodes = countNodesinCompleteBinaryTree(root.left);
        int rightNodes = countNodesinCompleteBinaryTree(root.right);
        return 1 + leftNodes + rightNodes;
    }

    // ## Construct A Binary Tree from
    // Inorder and Preorder Traversal
    public static TreeNode buildBinaryTreefromInAndPre(int[] inOrder, int[] preOrder) {
        if (inOrder == null || preOrder == null || inOrder.length != preOrder.length)
            return null;
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i], i);
        }
        TreeNode root = buildBinaryTreeInAndPreCore(inOrder, 0, inOrder.length - 1, preOrder, 0, preOrder.length - 1,
                inMap);
        return root;
    }

    public static TreeNode buildBinaryTreeInAndPreCore(int[] inOrder,
            int inStart,
            int inEnd,
            int[] preOrder,
            int preStart,
            int preEnd,
            Map<Integer, Integer> inMap) {

        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preOrder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildBinaryTreeInAndPreCore(inOrder, inStart, inRoot - 1,
                preOrder, preStart + 1, preStart + numsLeft, inMap);
        root.right = buildBinaryTreeInAndPreCore(inOrder, inRoot + 1, inEnd,
                preOrder, preStart + numsLeft + 1, preEnd, inMap);

        return root;
    }

    // ## Construct A Binary Tree from
    // Inorder and Preorder Traversal
    public static TreeNode buildTreeFromInAndPostOrder(int[] inOrder, int[] postOrder) {
        if (inOrder == null || postOrder == null || inOrder.length != postOrder.length)
            return null;
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i], i);
        }
        return buildTreeFromInAndPostOrderCoreLogic(inOrder, postOrder,
                0, inOrder.length - 1,
                0, postOrder.length - 1, inMap);
    }

    private static TreeNode buildTreeFromInAndPostOrderCoreLogic(int[] inOrder, int[] postOrder,
            int inStart, int inEnd, int postStart, int postEnd, HashMap<Integer, Integer> inMap) {
        if (postStart > postEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postOrder[postEnd]);
        int rootIndex = inMap.get(postOrder[postEnd]);
        int numsLeft = rootIndex - inStart;
        root.left = buildTreeFromInAndPostOrderCoreLogic(inOrder, postOrder,
                inStart, rootIndex - 1,
                postStart, postStart + numsLeft - 1,
                inMap);

        root.right = buildTreeFromInAndPostOrderCoreLogic(inOrder, postOrder,
                rootIndex + 1, inEnd,
                (postStart + numsLeft), (postEnd - 1),
                inMap);

        return root;
    }

    // #####
    // https://takeuforward.org/data-structure/serialize-and-deserialize-a-binary-tree/
    // serialize-and-deserialize-a-binary-tree
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "")
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
    // ## Morris Inorder Traversal of a Binary tree
    // https://takeuforward.org/data-structure/morris-inorder-traversal-of-a-binary-tree/

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();

        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                inorder.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    inorder.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return inorder;
    }

    // ### Morris Preorder Traversal of a Binary Tree
    // https://takeuforward.org/data-structure/morris-preorder-traversal-of-a-binary-tree/
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static ArrayList<Integer> preorderTraversal(Node root) {
        ArrayList<Integer> preorder = new ArrayList<>();
        Node cur = root;
        while (cur != null) {
            if (cur.left == null) {
                preorder.add(cur.data);
                cur = cur.right;
            } else {
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    preorder.add(cur.data);
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return preorder;
    }
    // https://takeuforward.org/data-structure/flatten-binary-tree-to-linked-list/
    // Flatten Binary Tree to Linked List

    public static class Solution {
        static Node prev = null;

        void flatten(Node root) {
            if (root == null) return;

            flatten(root.right);
            flatten(root.left);

            root.right = prev;
            root.left = null;
            prev = root;
        }

        // ############################ Plumbing Code
        public static void main(String args[]) {
            TreeNode root = getTree();

            TreeNode root1 = new TreeNode(1);
            root1.left = new TreeNode(2);
            TreeNode root2 = new TreeNode(1);
            root1.right = new TreeNode(2);
            // ## IN-ORDER TRAVERSALS
            ArrayList<Integer> inOrder;
            inOrder = inOrderIterativeTraversal(root);
            printBinaryTree(inOrder, "IN_ORDER", "ITERATIVE");
            inOrder.clear();
            inOrderRecursiveTraversal(root, inOrder);
            printBinaryTree(inOrder, "IN_ORDER", "RECURSIVE");
            // ## PRE-ORDER TRAVERSALS
            ArrayList<Integer> preOrder = preOrderIterativeTraversal(root);
            printBinaryTree(preOrder, "PRE_ORDER", "ITERATIVE");
            preOrder.clear();
            preOrderRecursiveTraversal(root, preOrder);
            printBinaryTree(preOrder, "PRE_ORDER", "RECURSIVE");
            // ## POST-ORDER TRAVERSALS
            ArrayList<Integer> postOrder = new ArrayList<>();
            postOrderRecursiveTraversal(root, postOrder);
            printBinaryTree(postOrder, "POST_ORDER", "RECURSIVE");
            postOrder.clear();
            postOrder = postOrderTwoStackTraversal(root);
            printBinaryTree(postOrder, "POST_ORDER_TWO_STACK", "RECURSIVE");

            System.out.println("isBalanced ? ::==> " + isBalancedBinaryTree(root));
            System.out.println("maxPathSum ? ::==> " + maxPathSum(root));

            System.out.println("isIdenticalTreesIterative ? ::==> " + isIdenticalTreesIterative(root1, root2));
            System.out.println("isIdenticalTreesRecursive ? ::==>" + isIdenticalTreesRecursive(root, getTree()));
            System.out.println("zigzagLevelOrder ? ::==> " + zigzagLevelOrder(root));
            BinaryTreeTraversalsTUF bts = new BinaryTreeTraversalsTUF();
            System.out.println("verticalOrderTraversalIterative ? ::==> " + bts.verticalOrderTraversalIterative(root));
            System.out.println("topView ? ::==> " + topViewIterative(root));
            System.out.println("bottomViewIterative ? ::==> " + bottomViewIterative(root));
            System.out.println("isSymmetricRecursive ? ::==> " + bts.isSymmetricRecursive(root));
            System.out.println("isSymmetricIterative ? ::==> " + bts.isSymmetricIterative(root));
            System.out.println("rightSideViewRecursive ? ::==> " + bts.rightSideViewRecursive(root));
            System.out.println("rightSideViewItertaive ? ::==> " + bts.rightSideViewItertaive(root));
            System.out.println("leftSideViewRecursive ? ::==> " + bts.leftSideViewRecursive(root));
            System.out.println("leftSideViewItertaive ? ::==> " + bts.leftSideViewItertaive(root));
            System.out.println("root2nodePath ? ::==> " + root2nodePath(root, 9));

            System.out.println("LCARecursive ? ::==> " + lCARecursive(root, new TreeNode(2), new TreeNode(3)));
            System.out.println(
                    "getAnsforlCARecursive2 ? ::==> " + getAnsforlCARecursive2(root, new TreeNode(2), new TreeNode(3)));

            System.out.println(" NodesAtdistanceK () ? ::==> " + NodesAtdistanceK(root, root.left.left, 1));
            System.out.println(" NodesAtdistanceKV2 () ? ::==> " + NodesAtdistanceKV2(root, root.left.left, 1));
            System.out.println(" NodesAtdistanceKV3 () ? ::==> " + NodesAtdistanceKV3(root, root.left.left, 1));
            System.out.println("countNodesinCompleteBinaryTree ? ::==> " + bts.countNodesinCompleteBinaryTree(root));
            int preorder[] = {10, 20, 40, 50, 30, 60};
            int inorder[] = {40, 20, 50, 10, 60, 30};
            System.out.println("buildBinaryTreefromInAndPre () ? ::==> " + buildBinaryTreefromInAndPre(inorder, preorder));
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

        static TreeNode getTree() {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(10);
            root.left.left.right = new TreeNode(5);
            root.left.left.right.right = new TreeNode(6);
            root.right = new TreeNode(3);
            root.right.left = new TreeNode(9);
            root.right.right = new TreeNode(12);
            return root;
        }

    }}
