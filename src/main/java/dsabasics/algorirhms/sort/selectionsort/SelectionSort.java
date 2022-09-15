package dsabasics.algorirhms.sort.selectionsort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = { 13, 255, 33, 4, 5, 92, 122, 16, 19, 25, 208, 33 };
        int[] sortedArray = selectionSort(array);
        printArray(sortedArray);

    }

    private static void printArray(int[] array) {
        System.out.print("{");
        Arrays.stream(array).forEach(i -> {
            System.out.print(i + ",");
        });
        System.out.println("}");
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
            System.out.print("i : " + i + "  | ");
            printArray(array);
        }
        return array;
    }

}
