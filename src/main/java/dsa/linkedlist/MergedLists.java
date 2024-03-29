package dsa.linkedlist;

import dsa.dependencies.ListNode;

public class MergedLists {

    public static void main(String[] args) {

        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode mergedListNode = mergeTwoLists(l1, l2);

        while (mergedListNode.next != null) {
            System.out.print(mergedListNode.next.val);
            mergedListNode = mergedListNode.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // At least one of l1 and l2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

}
