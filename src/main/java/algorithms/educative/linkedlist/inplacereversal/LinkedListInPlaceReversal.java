package algorithms.educative.linkedlist.inplacereversal;

class ListNode {

    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }

}

class LinkedListInPlaceReversal {

    public static ListNode alternateReverse(ListNode head, int k) {
        if (k <= 1) return head;
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;
        for (int i = 0; curr != null && i < k ; i++) {
            if(i<0 && i/k==0) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
        }
        return head;
    }

    public static ListNode reverse(ListNode head, int p, int q) {
        if (p == q) return head;
        ListNode curr = head;
        ListNode prev = null;
        for (int i = 0; curr != null && i < p - 1; ++i) {
            prev = curr;
            curr = curr.next;
        }
        ListNode lnfp = prev;
        ListNode lnsl = curr;
        ListNode next = null;
        for (int i = 0; curr != null && i < q - p + 1; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if (lnfp != null)
            lnfp.next = prev;
        else
            head = prev;
        lnsl.next = curr;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = LinkedListInPlaceReversal.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

}