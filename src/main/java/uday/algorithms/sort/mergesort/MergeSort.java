package uday.algorithms.sort.mergesort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] array = {13, 255, 33, 4, 5, 92, 122, 16, 19, 25, 208, 33};
        mergeSort(array, 0, array.length - 1);
        printArray(array);

    }

    private static void printArray(int[] array) {
        System.out.print("{");
        Arrays.stream(array).forEach(i -> {
            System.out.print(i + ",");
        });
        System.out.println("}");
    }

    private static void mergeSort(int[] array, int p, int r) {
        if (r <= p) {
            return ;
        }
        int q = (p + r) / 2;
        mergeSort(array, p, q);
        mergeSort(array, q + 1, r);
        merge(array, p, q, r);

    }


    private static void merge(int[] array, int p, int q, int r) {
        int[] tempArray = new int[r - p + 1];
        int leftSlot = p;
        int rightSlot = q + 1;
        int k = 0;
        while (leftSlot <= q && rightSlot <= r) {
            if (array[leftSlot] < array[rightSlot]) {
                tempArray[k] = array[leftSlot];
                leftSlot++;
            } else {
                tempArray[k] = array[rightSlot];
                rightSlot++;
            }
            k++;
        }
        /* Reached here means ...   The LOOP is completed so both right and left of sub array are considered to be sorted */
        if (leftSlot <= q) { /* Right is conidered sorted as left must be sorted already */
            while (leftSlot <= q) {
                tempArray[k] = array[leftSlot];
                leftSlot++;
                k++;
            }
        } else if (rightSlot <= r) {
            while (rightSlot <= r) {
                tempArray[k] = array[rightSlot];
                rightSlot++;
                k++;
            }
        }
        /* Copy over temp array into appropriate slots of original array*/
        for (int i = 0; i < tempArray.length; i++) {
            array[p + i] = tempArray[i];
        }
       // printArray(array);
    }
}
