package algorithms.leetcode.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SmallerThanCurrent {

    public static void main(String[] args) {
        SmallerThanCurrent smallerThanCurrent = new SmallerThanCurrent();
        smallerThanCurrent.smallerNumbersThanCurrent(new int[] { 8, 1, 2, 2, 3 });
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] copy = nums.clone();
        Arrays.sort(copy);
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(copy[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            copy[i] = map.get(nums[i]);
        }
        return copy;
    }

}
