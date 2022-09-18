package dsabasics.datastructures.heap;

public class Heap {

    public static void main(String[] args) {
        Heap heap = new Heap(5);
        heap.insert(10);
        heap.insert(5);
        heap.insert(8);
        heap.insert(1);
        heap.insert(20);

    }

    private Node heapArray[];
    private int maxSize; // Size of Array
    private int currentSize; // umber if nodes in Array

    public Heap(int size) {
        this.maxSize = size;
        currentSize = 0;
        heapArray = new Node[size];
    }

    public int getSize() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public boolean insert(int key) {
        if (!isFull()) {
            Node node = new Node();
            node.setKey(key);
            heapArray[currentSize] = node;
            trickleUp(currentSize); // placing the node at right place in heap
            currentSize++;
            return true;
        }
        return false;
    }

    private void trickleUp(int index) {
        int parentIdx = (index - 1) / 2;
        Node nodeToInsert = heapArray[index];
        // Loop as long as we hanvn't reached to the root and key of node to insert
        // parent is less than new code
        while (index > 0 && heapArray[parentIdx].getKey() < nodeToInsert.getKey()) {
            heapArray[index] = heapArray[parentIdx]; // move parent down.
            index = parentIdx;
            parentIdx = (parentIdx - 1) / 2; // Move up
        }
        heapArray[index] = nodeToInsert;
    }

    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    private void trickleDown(int index) {
        int largerChildIndex;
        Node top = heapArray[index]; // saving lat into top variable
        while (index < currentSize / 2) {
            // left child index position
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index - 1;
            // identif which child is larger
            if (rightChildIndex < currentSize
                    && heapArray[leftChildIndex].getKey() < heapArray[rightChildIndex].getKey()) {
                largerChildIndex = rightChildIndex;
            } else {
                largerChildIndex = leftChildIndex;
            }
            if (top.getKey() > heapArray[largerChildIndex].getKey()) {
                // successfully made to the top or largest key
                break;
            }
            heapArray[index] = heapArray[largerChildIndex];
            index = largerChildIndex;
        }
        heapArray[index] = top;
    }

    public void displayHeap() {
        // UDAY this Assignment is pending
    }

}
