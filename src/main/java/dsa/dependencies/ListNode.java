package dsa.dependencies;

public class ListNode {

    public int val;
    public  ListNode next;
    public ListNode previous = null;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public int getval() {
        return val;
    }

    public void setval(int val) {
        this.val = val;
    }

    public void displayNode() {
        System.out.println("{ " + val + " } ");
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getPrevious() {
        return previous;
    }

    public void setPrevious(ListNode previous) {
        this.previous = previous;
    }
}
