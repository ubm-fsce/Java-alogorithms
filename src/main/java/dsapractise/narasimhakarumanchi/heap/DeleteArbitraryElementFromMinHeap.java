package dsapractise.narasimhakarumanchi.heap;

public class DeleteArbitraryElementFromMinHeap {

    int heapSize, capacity;
    int[] heapArray;

    public DeleteArbitraryElementFromMinHeap(int cap) {

        this.capacity = cap;
        heapArray = new int[capacity];
    }

    private int getParent(int i) {
        int temp = (i - 1) / 2;
        System.out.println("Parent : " + temp);
        return temp;
    }

    private int getleftChild(int i) {
        int temp = (2 * i) + 1;
        System.out.println("LeftChild : " + temp);
        return temp;
    }

    private int getRightChild(int i) {
        int temp = (2 * i) + 2;
        System.out.println("Right Child : " + temp);
        return temp;

    }

    private void swapElements(int i, int j) {
        int temp = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = temp;
    }

    private void insertKey(int key) {
        if (heapSize == capacity) {
            System.out.println("Max Size Reached !");
            return;
        }
        heapArray[heapSize] = key;
        int i = heapSize;
        heapSize++;
        System.out.println("heapArray[getParent(i)] " + heapArray[getParent(i)] + "> heapArray[i] " + heapArray[i]);
        while (i != 0 && heapArray[getParent(i)] > heapArray[i]) {
            swapElements(i, getParent(i));
            i = getParent(i);
        }
    }

    private int findKey(int key, int levelInHeap) {
        if (heapSize == 0) {
            System.out.println("Heap is Empty");
            return -1;
        }

        System.out.println("Key : " + key + " | levelInHeap : " + levelInHeap + " | heapArray[levelInHeap] : "
                + heapArray[levelInHeap]);
        if (levelInHeap > (heapSize - 1) / 2) {
            System.out.println("Not found");
            return -1;
        }
        if (key == heapArray[levelInHeap])
            return levelInHeap;
        findKey(key, getleftChild(levelInHeap));
        findKey(key, getRightChild(levelInHeap));
        return -1;
    }

    private boolean isLeaf(int pos) {
        if (pos > (heapSize / 2) && pos <= heapSize) {
            return true;
        }
        return false;
    }

    private int[] deleteRandomElement(int random) {
        int pos = findKey(random, 0);
        int temp = heapArray[random];
        int lastElement = heapArray[heapSize];
        heapArray[random] = lastElement;
        heapSize--;
        minHeapify(0);
        return heapArray;
    }

    private void minHeapify(int pos) {

        // If the node is a non-leaf node and greater
        // than any of its child
        if (!isLeaf(pos)) {
            if (heapArray[pos] > heapArray[getleftChild(pos)]
                    || heapArray[pos] > heapArray[getRightChild(pos)]) {

                // Swap with the left child and heapify
                // the left child
                if (heapArray[getleftChild(pos)] < heapArray[getRightChild(pos)]) {
                    swapElements(pos, getleftChild(pos));
                    minHeapify(getleftChild(pos));
                }

                // Swap with the right child and heapify
                // the right child
                else {
                    swapElements(pos, getRightChild(pos));
                    minHeapify(getRightChild(pos));
                }
            }
        }
    }

    public static void main(String[] args) {
        DeleteArbitraryElementFromMinHeap h = new DeleteArbitraryElementFromMinHeap(15);
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
        int x = 100;
        System.out.println(h.deleteRandomElement(77));
    }

}
