package algorithms.narasimhakarumanchi.binarytree;

public class BinarySearchTreePractise {

    class Node {

        Node left, right;
        int key;

    }

    Node newNode(int key) {
        Node ptr = new Node();
        ptr.key = key;
        ptr.left = null;
        ptr.right = null;
        return ptr;
    }

    // Standard BST insert function
    Node insert(Node root, int key) {
        if (root == null)
            root = newNode(key);
        else if (root.key > key)
            root.left = insert(root.left, key);
        else if (root.key < key)
            root.right = insert(root.right, key);
        return root;
    }

    // This function returns distance of x from
    // root. This function assumes that x exists
    // in BST and BST is not NULL.
    int distanceFromRoot(Node root, int x) {
        if (root.key == x)
            return 0;
        else if (root.key > x)
            return 1 + distanceFromRoot(root.left, x);
        return 1 + distanceFromRoot(root.right, x);
    }

    // Returns minimum distance between a and b.
    // This function assumes that a and b exist
    // in BST.
    int distanceBetween2(Node root, int a, int b) {
        if (root == null)
            return 0;
        // Both keys lie in left
        if (root.key > a && root.key > b)
            return distanceBetween2(root.left, a, b);
        // Both keys lie in right
        if (root.key < a && root.key < b) // same path
            return distanceBetween2(root.right, a, b);
        // Lie in opposite directions (Root is
        // LCA of two nodes)
        if (root.key >= a && root.key <= b)
            return distanceFromRoot(root, a) + distanceFromRoot(root, b);
        return 0;
    }

    /*
     * TODO: 52) Give an algorithm for finding the shortest path between two nodes
     * in a BST
     */
    // This function make sure that a is smaller
    // than b before making a call to findDistWrapper()
    int findDistWrapper(Node root, int a, int b) {
        int temp = 0;
        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        }
        return distanceBetween2(root, a, b);
    }

    /*
     * TODO: 54) Given pointers to two nodes in a binary search tree, find the
     * lowest common
     * ancestor (LCA). Assume that both values already exist in the tree.
     */
    /*
     * Function to find LCA of n1 and n2. The function assumes that both
     * n1 and n2 are present in BST
     */
    private Node lca(Node node, int n1, int n2) {
        if (node == null)
            return null;
        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.key > n1 && node.key > n2)
            return lca(node.left, n1, n2);
        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.key < n1 && node.key < n2)
            return lca(node.right, n1, n2);
        return node;
    }

    /*
     * TODO: 55) Approach 1 : Give an algorithm to check whether the given binary
     * tree is a BST or not.
     */
    boolean isBST(Node node) {
        if (node == null)
            return true;
        /* False if left is > than node */
        if (node.left != null && node.left.key > node.key)
            return false;
        /* False if right is < than node */
        if (node.right != null && node.right.key < node.key)
            return false;
        /* False if, recursively, the left or right is not a BST */
        if (!isBST(node.left) || !isBST(node.right))
            return false;

        /* Passing all that, it's a BST */
        return true;
    }

    /*
     * TODO: 55) Approach 2 : Give an algorithm to check whether the given binary
     * tree is a BST or not.
     */
    // Returns true if given tree is BST.
    private boolean isBSTApproach2(Node root, Node l, Node r) {
        // Base condition
        if (root == null)
            return true;
        // if left node exist then check it has
        // correct data or not i.e. left node's data
        // should be less than root's data
        if (l != null && root.key <= l.key)
            return false;
        // if right node exist then check it has
        // correct data or not i.e. right node's data
        // should be greater than root's data
        if (r != null && root.key >= r.key)
            return false;
        // check recursively for every node.
        return isBSTApproach2(root.left, l, root) && isBSTApproach2(root.right, root, r);
    }

    /*
     * Returns true if the given tree is a BST and its
     * values are >= min and <= max.
     */
    boolean isBSTUtil(Node node, int min, int max) {
        /* an empty tree is BST */
        if (node == null)
            return true;
        /* false if this node violates the min/max constraints */
        if (node.key < min || node.key > max)
            return false;
        /*
         * otherwise check the subtrees recursively tightening the min/max constraints
         */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.key - 1) && isBSTUtil(node.right, node.key + 1, max));
    }

    // TODO :59) Give an algorithm for converting BST to circular DLL with space
    // complexity
    // Display Circular Link List
    public void display(Node head) {
        System.out.println("Circular Linked List is :");
        Node itr = head;
        do {
            System.out.print(itr.key + " ");
            itr = itr.right;
        } while (itr != head);
        System.out.println();
    }

    /*
     * TODO :59) Give an algorithm for converting BST to circular DLL with space
     * complexity
     * Method converts a tree to a circular Link List and then returns the head of
     * the Link List
     */
    public Node bTreeToCList(Node root) {
        System.out.println("Enter");
        if (root == null)
            return null;
        // Recursively convert left and right subtrees
        if (root != null)
            System.out.println("ROOT : " + root.key);
        if (root != null && root.left != null)
            System.out.println("ROOT.:LEFT : " + root.left.key);
        Node left = bTreeToCList(root.left);
        if (root != null && root.right != null)
            System.out.println("ROOT.:Right : " + root.right.key);
        Node right = bTreeToCList(root.right);
        // Make a circular linked list of single node
        // (or root). To do so, make the right and
        // left pointers of this node point to itself
        root.left = root.right = root;
        // Step 1 (concatenate the left list with the list
        // with single node, i.e., current node)
        // Step 2 (concatenate the returned list with the
        // right List)
        return concatenate(concatenate(left, root), right);
    }

    /*
     * TODO :59) Give an algorithm for converting BST to circular DLL with space
     * complexity
     * concatenate both the lists and returns the head of the List
     */

    public Node concatenate(Node leftList, Node rightList) {
        System.out.println(" concatenate ");
        if (leftList != null) {
            System.out.println(" LeftList : " + leftList.key);
        } else {
            System.out.println(" leftList is NULL ::: ");
        }
        if (rightList != null) {
            System.out.println(" rightList : " + rightList.key);
        } else {
            System.out.println(" rightList is NULL ::: ");
        }

        // If either of the list is empty, then
        // return the other list
        if (leftList == null)
            return rightList;
        if (rightList == null)
            return leftList;
        // Store the last Node of left List
        Node leftLast = leftList.left;
        // Store the last Node of right List
        Node rightLast = rightList.left;
        // Connect the last node of Left List
        // with the first Node of the right List
        leftLast.right = rightList;
        rightList.left = leftLast;
        // left of first node refers to
        // the last node in the list
        leftList.left = rightLast;
        // Right of last node refers to the first
        // node of the List
        rightLast.right = leftList;
        // Return the Head of the List
        return leftList;
    }

    // Driver code
    public static void main(String[] args) {
        BinarySearchTreePractise sdbn = new BinarySearchTreePractise();
        Node root = null;
        root = sdbn.insert(root, 20);
        sdbn.insert(root, 10);
        sdbn.insert(root, 5);
        sdbn.insert(root, 1);
        sdbn.insert(root, 15);
        sdbn.insert(root, 30);
        sdbn.insert(root, 25);
        sdbn.insert(root, 35);

        /*
         * sdbn.insert(root, 10);
         * sdbn.insert(root, 5);
         * sdbn.insert(root, 15);
         * sdbn.insert(root, 11);
         * sdbn.insert(root, 12);
         * sdbn.insert(root, 13);
         * sdbn.insert(root, 14);
         * sdbn.insert(root, 16);
         * sdbn.insert(root, 17);
         * sdbn.insert(root, 30);
         * sdbn.insert(root, 25);
         * sdbn.insert(root, 35);
         */
        // TODO: 52) Give an algorithm for finding the shortest path between two nodes
        // in a BST
        // System.out.println(sdbn.findDistWrapper(root, 5, 35));
        /*
         * TODO: 54) Given pointers to two nodes in a binary search tree, find the
         * lowest common
         * ancestor (LCA). Assume that both values already exist in the tree.
         */
        // System.out.println(sdbn.lca(root, 12, 13).key);
        // TODO: 55) Give an algorithm to check whether the given binary tree is a BST
        // or not.
        // System.out.println(sdbn.isBSTUtil(root, Integer.MIN_VALUE,
        // Integer.MAX_VALUE));
        // TODO: 55) Approach 2 : 55) Approach 2 : Give an algorithm to check whether
        // the given binary tree is a BST or not.
        // System.out.println(sdbn.isBSTApproach2(root, null, null));
        // head refers to the head of the Link List
        Node head = sdbn.bTreeToCList(root);

        // Display the Circular LinkedList
        sdbn.display(head);
    }

}
