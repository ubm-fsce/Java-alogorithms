package dsa.heap;

public class MinHeapKthSmallest {

    int[] heapArray;
    int capacity;
    int heapSize;

    public MinHeapKthSmallest(int cap) {
        capacity = cap;
        heapSize = 0;
        heapArray = new int[cap];
    }

    private int getParentNode(int i) {
        return (i - 1) / 2;
    }

    private int getLeftChild(int i) {
        return 2 * i + 1;
    }

    private int getRightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int x, int y) {
        int temp = heapArray[x];
        heapArray[x] = heapArray[y];
        heapArray[y] = temp;
    }

    public void heapify(int[] arr, int i) {
        int left = getLeftChild(i);
        int right = getRightChild(i);
        int max = i;
        if (left < heapSize && arr[i] > arr[left]) {
            max = left;
        } else
            max = i;
        if (right < heapSize && arr[right] > arr[max]) {
            max = right;
        }
        // Put maximum value at root and
        // recur for the child with the
        // maximum value
        if (max != i) {
            swap(heapArray[max], heapArray[i]);
            heapify(arr, max);
        }
    }

    private int extractMin() {
        if (heapArray.length == 0)
            return -1;
        int min = heapArray[0];
        // pending
        return -1;
    }

}
