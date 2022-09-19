package dsa.linkedlist;

import dsa.linkedlist.dependencies.ListNode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

    private static ListNode getTestData() {
        ListNode lc4 = new ListNode(1);
        ListNode lc3 = new ListNode(2, lc4);
        ListNode lc2 = new ListNode(2, lc3);
        ListNode lc = new ListNode(1, lc2);
        ListNode node = lc;
        while (node != null) {
            System.out.println("Value " + node.val);
            node = node.next;
        }
        return lc;
    }

    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        ListNode lc = getTestData();
        palindromeLinkedList.isPalindrome2(lc);
    }

    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next))
                return false;
            if (currentNode.val != frontPointer.val)
                return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        // Convert LinkedList into ArrayList.
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }
        // Use two-pointer technique to check for palindrome.
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            // Note that we must use ! .equals instead of !=
            // because we are comparing Integer, not int.
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

}
