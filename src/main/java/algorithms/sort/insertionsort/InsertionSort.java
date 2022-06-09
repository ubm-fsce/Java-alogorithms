package algorithms.sort.insertionsort;

import java.util.Arrays;
import java.util.HashSet;

public class InsertionSort {
    public static void main(String[] args) {
        int array[] = {13, 255, 33, 4, 5, 92, 122, 16, 19, 25, 208, 33};
        int[] sortedArray = insertionSort(array);
        System.out.print("{");
        Arrays.stream(sortedArray).forEach(i -> {
            System.out.print(i + ",");
        });
        System.out.println("}");
    }
    private static void printArray(int[] array) {
        System.out.print("{");
        Arrays.stream(array).forEach(i -> {
            System.out.print(i + ",");
        });
        System.out.println("}");
    }

    public static int[] insertionSort(int array[]) {
        for(int i=1; i< array.length;i++ ){
            int j = i-1;
            int element = array[i];
            while (j>=0 && array[j]>element){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = element;
            System.out.print("i : "+i+"  | ");
            printArray(array);
        }

    return array;
    }

    public static int[] insertionSortjunk(int array[]) {
        HashSet<Integer> set = new HashSet<>();
        boolean b = set.add(array[0]);
        for(int i : array ){
            int j = i-1;
            int element = array[i];
            while (j>=0 && array[j]>element){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = element;
            System.out.print("i : "+i+"  | ");
            printArray(array);
        }

        return array;
    }



}
