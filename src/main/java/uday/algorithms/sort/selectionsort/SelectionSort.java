package uday.algorithms.sort.selectionsort;

import java.util.Arrays;
import java.util.List;

public class SelectionSort {
    public static void main(String[] args) {
        int array[] = {13, 255, 33, 4, 5, 92, 122, 16, 19, 25, 208, 33};
        List<Integer> sourceList = Arrays.asList(13, 255, 33, 4, 5, 92, 122, 16, 19, 25, 208, 33);
        int[] sortedArray = selectionSort(array);
        Arrays.asList(sortedArray).stream().forEach(System.out::print);
    }



    public static int[] selectionSort(int array[]) {
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
        }
        return array;
    }
}
