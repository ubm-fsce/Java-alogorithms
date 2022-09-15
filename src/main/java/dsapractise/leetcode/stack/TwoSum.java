package dsapractise.leetcode.stack;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] a = { 3, 2, 4, 6, 5, 9, 7, 1 };
        Arrays.sort(a);
        int target = 14;
        // int result[] = twoSumBF(a, target);
        int result[] = twoSum3(a, target);
        System.out.println(" i: " + result[0] + " j : " + result[1]);
    }

    private static int[] twoSumBF(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (target == a[i] + a[j])
                    return new int[] { i, j };
            }
        }
        return null;
    }

    private static int[] twoSumHashMap(int[] a, int target) {
        HashMap<Integer, Integer> resultsMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            resultsMap.put(a[i], i);
        }
        for (int i = 0; i < a.length; i++) {
            int complement = target - a[i];
            if (resultsMap.containsKey(complement) && resultsMap.get(complement) != i) {
                return new int[] { i, resultsMap.get(target - a[i]) };
            }
        }
        return null;
    }

    /* NOTE : This works only for sorted arrays */
    public static int[] twoSum3(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target)
                return new int[] { left, right };
            else if (numbers[left] + numbers[right] > target)
                right--;
            else
                left++;
        }
        return new int[] {};
    }

}
