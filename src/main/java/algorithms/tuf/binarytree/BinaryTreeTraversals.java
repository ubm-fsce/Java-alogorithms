package algorithms.tuf.binarytree;

import java.util.ArrayList;
import java.util.Stack;

class Node {

    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTreeTraversals {
  //  ############################ IN Order Traversal ############################
    static ArrayList<Integer> inOrderIterativeTraversal(Node curr) {
       ArrayList<Integer> inOrder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while(true){
            if(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }else {
                if(stack.isEmpty()) break;
                curr =stack.pop();
                inOrder.add(curr.data);
               // stack.pop();
                curr=curr.right;
            }
        }
    return  inOrder;
    }

    static void inOrderRecursiveTraversal(Node curr,ArrayList<Integer> inOrder ) {
       if(curr==null) return;
        inOrderRecursiveTraversal(curr.left, inOrder);
        inOrder.add(curr.data );
        inOrderRecursiveTraversal(curr.right, inOrder);


    }

    //  ############################ PRE Order Traversal ############################

    static ArrayList<Integer> preOrderIterativeTraversal(Node curr) {
        ArrayList<Integer> preOrderList = new ArrayList();
        if(curr==null) return preOrderList;
        Stack<Node> stack = new Stack();
        stack.push(curr);
        while(!stack.isEmpty()){
            Node top = stack.pop();
            preOrderList.add(top.data);
            if(top.right!=null) stack.push(top.right);
            if(top.left!=null) stack.push(top.left);
        }

        return preOrderList;
    }

    static void preOrderRecursiveTraversal(Node curr, ArrayList<Integer> preOrderList){
        if(curr==null) return;
        preOrderList.add(curr.data);
        preOrderRecursiveTraversal(curr.left, preOrderList);
        preOrderRecursiveTraversal(curr.right, preOrderList);


    }

    //  ############################ POST Order Traversal ############################
    static void postOrderRecursiveTraversal( Node curr, ArrayList<Integer> postOrderList){
        if(curr==null) return;
        postOrderRecursiveTraversal(curr.left, postOrderList);
        postOrderRecursiveTraversal(curr.right, postOrderList);
        postOrderList.add(curr.data);
    }

    static ArrayList<Integer> postOrderTwoStackTraversal(Node curr){
        ArrayList<Integer> postOrderList = new ArrayList();
        if(curr==null) return postOrderList;
        Stack<Node> s1 = new Stack();
        Stack<Node> s2 = new Stack();
        s1.push(curr);
        while(!s1.isEmpty()){
            curr =s1.pop();
            s2.push(curr);
            if(curr.left!=null) s1.push(curr.left);
            if(curr.right!=null) s1.push(curr.right);

        }
    while(!s2.isEmpty()){
        postOrderList.add(s2.pop().data);
    }
        return postOrderList;
    }






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

        ArrayList < Integer > inOrder;
        inOrder = inOrderIterativeTraversal(root);
        printBinaryTree(inOrder, "IN_ORDER", "ITERATIVE");
        inOrderRecursiveTraversal(root, inOrder);
        printBinaryTree(inOrder, "IN_ORDER", "RECURSIVE");

        preOrderIterativeTraversal(root);
        printBinaryTree(inOrder, "PRE_ORDER", "ITERATIVE");
        preOrderRecursiveTraversal(root, inOrder);
        printBinaryTree(inOrder, "PRE_ORDER", "RECURSIVE");
        postOrderRecursiveTraversal(root,inOrder);
        printBinaryTree(inOrder, "POST_ORDER", "RECURSIVE");
        postOrderTwoStackTraversal(root);
        printBinaryTree(inOrder, "POST_ORDER_TWO_STACK", "RECURSIVE");
    }

    private static void printBinaryTree(ArrayList<Integer> inOrder,String...  name) {
        System.out.println("The "+name[0]+" Traversal with Approach "+name[1]+":  BEGIN");
        for (int i = 0; i < inOrder.size(); i++) {
            System.out.print(inOrder.get(i) + " ");
        }
        System.out.println( "");
        System.out.println("The "+name[0]+" Traversal with Approach "+name[1]+": END ");
    }

}
