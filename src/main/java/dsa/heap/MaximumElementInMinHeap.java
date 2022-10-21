package dsa.heap;

public class MaximumElementInMinHeap {

    int heapSize;
    int capacity;
    int[] heapArray;

    public MaximumElementInMinHeap(int cap) {
        this.capacity = cap;
        heapSize = 0;
        heapArray = new int[capacity];
    }

    int getParent(int i) {
        return (i - 1) / 2;
    }

    int getLeftChild(int i) {
        return 2 * i + 1;
    }

    int getRightChild(int i) {
        return 2 * i + 1;
    }

    private void insertKey(int key) {
        if (heapSize == capacity) {
            System.out.println("Max Size Reached !");
            return;
        }
        heapArray[heapSize] = key;
        int i = heapSize;
        heapSize++;
        while (i != 0 && heapArray[getParent(i)] > heapArray[i]) {
            swapElements(i, getParent(i));
            i = getParent(i);
        }
    }

    private void swapElements(int i, int parent) {
        int temp = heapArray[parent];
        heapArray[parent] = heapArray[i];
        heapArray[i] = temp;
    }

    private int getMaxElementInMinHeap() {
        int max = Integer.MIN_VALUE;
        for (int i = (heapSize + 1) / 2; i < heapSize; i++) {
            max = Math.max(max, heapArray[i]);
        }
        return max;
    }

    public static void main(String[] args) {

        MaximumElementInMinHeap h = new MaximumElementInMinHeap(15);
        h.insertKey(150);
        h.insertKey(3);
        h.insertKey(2);
        h.insertKey(80);
        h.insertKey(120);
        h.insertKey(45);
        h.insertKey(15);
        h.insertKey(5);
        h.insertKey(4);
        h.insertKey(6);
        h.insertKey(77);
        h.insertKey(1);
        h.insertKey(9);
        h.insertKey(22);

        // Print all nodes smaller than 100.
        // int x = 100;
        System.out.println(h.getMaxElementInMinHeap());
    }
}
