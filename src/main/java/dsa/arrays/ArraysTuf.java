package dsa.arrays;

import java.util.Arrays;

public class ArraysTuf {

    public static void main(String[] args) {
        // Longest Element in Array
        // Option 1 Longest Element in Array
        int[] arr = { 1, 3, 2, 5, 4 };
        Arrays.sort(arr);
        System.out.println(arr[arr.length - 1]);
        // Option 2  Longest Element in Array
        int max2 = Arrays.stream(arr).reduce(Integer.MIN_VALUE, (x, y) -> x < y ? y : x);
        System.out.println(max2);
        // Option 3 Longest Element in Array
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = arr[i] < max ? max : arr[i];
        }
        System.out.println(max);

    }

}

