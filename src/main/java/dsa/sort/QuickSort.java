package dsa.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String args[]) {
        int[] array = { 13, 255, 33, 4, 5, 92, 122, 16, 19, 25, 208, 33 };
        quickSort(array, 0, array.length - 1);
        printArray(array);
    }

    private static void printArray(int[] array) {
        System.out.print("{");
        Arrays.stream(array).forEach(i -> {
            System.out.print(i + ",");
        });
        System.out.println("}");
    }

    private static void quickSort(int array[], int p, int r) {
        if (p < r) {
            int partionPoint = partition(array, p, r);
            quickSort(array, p, partionPoint - 1);
            quickSort(array, partionPoint + 1, r);
        }
    }

    private static int partition(int array[], int p, int r) {
        int pivot = array[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (array[j] <= pivot) {
                i++;
                swapValesAtGivenPosition(array, i, j);
                /* this completes moving of smaller values before pivot position */
                printArray(array);
            }
        }
        /* put the Pivot value in the correct Slot */
        int ival = array[i + 1];
        array[r] = ival;
        array[i + 1] = pivot; // here pivot value is placed in the collect slot of array
        printArray(array);
        return i + 1;
    }

    private static void swapValesAtGivenPosition(int[] array, int i, int j) {
        int iValue = array[i];
        array[i] = array[j];
        array[j] = iValue;
    }

}
