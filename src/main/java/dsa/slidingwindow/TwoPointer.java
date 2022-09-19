package dsa.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TwoPointer {
    /*
     * public static int findLength(int[] arr, int k) {
     * // : Write your code here
     * if((arr==null) || (arr.length==0)) return -1;
     * int maxLength=0, start=0;
     * int onesum=0;
     * int al =arr.length;
     * for(int i=0; i<al; i++){
     * if(arr[i]==1) {onesum++;}
     * if(i+1-start-onesum>k){
     * if(arr[start]==1){
     * onesum--;
     * }
     * start++;
     * }
     * maxLength = Math.max(maxLength, i+1-start);
     * }
     * 
     * return maxLength;
     * }
     */

    /*
     * public class StringPermutation {
     * public boolean findPermutation(String str, String pattern) {
     * HashMap<Character, Integer> patternMap = new HashMap();
     * for(Character ch: pattern.toCharArray()){
     * patternMap.put(ch, patternMap.getOrDefault(ch, 0)+1);
     * }
     * int matched = 0;
     * int len = str.length();
     * int start=0;
     * for(int i=0;i<len; i++){
     * Character tChar = str.charAt(i);
     * patternMap.put(tChar, patternMap.getOrDefault(tChar, 0)-1);
     * if(patternMap.get(tChar)==0) matched++;
     * if(matched==pattern.length()) return true;
     * if(i+1-start>pattern.length()){
     * Character sChar = str.charAt(start);
     * patternMap.put(sChar, patternMap.getOrDefault(sChar, 0)+1);
     * start++;
     * }
     * 
     * 
     * }
     * 
     * return false;
     * }
     * }
     */
    /*
     * public static class PairWithTargetSum {
     * 
     * public int[] search(int[] arr, int targetSum) {
     * // : Write your code here
     * int al = arr.length;
     * int left=0;
     * int right=arr.length-1;
     * while(left <right) {
     * int tempsum = arr[left]+arr[right];
     * if(tempsum ==targetSum) {
     * return new int [] {left, right};
     * }
     * else if (tempsum>targetSum){
     * right--;
     * }
     * else if (tempsum<targetSum){
     * left++;
     * }
     * }
     * return new int[] { -1, -1 };
     * }
     * }
     */
    public static int remove(int[] arr) {
        // : Write your code here
        int nondupindex = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[nondupindex - 1]) {
                arr[nondupindex] = arr[i];
                nondupindex++;
            }
        }
        return nondupindex;
    }

    /*
     * public static void main(String[] args) {
     * System.out.println(MaxRepeat.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1,
     * 0, 1, 1 }, 2));
     * System.out.println(MaxRepeat.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1,
     * 1, 0, 0, 1, 1 }, 3));
     * }
     */
    /*
     * public static void main(String[] args) {
     * PairWithTargetSum pts = new PairWithTargetSum();
     * int[] result = pts.search(new int[] { 1, 2, 3, 4, 6 }, 6);
     * System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] +
     * "]");
     * result = pts.search(new int[] { 2, 5, 9, 11 }, 11);
     * System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] +
     * "]");
     * }
     */
    /*
     * public static void main(String[] args) {
     * int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
     * System.out.println(MaxRepeat.remove(arr));
     * 
     * arr = new int[] { 2, 2, 2, 11 };
     * System.out.println(MaxRepeat.remove(arr));
     * 
     * }
     */
    /*
     * public static void main(String[] args) {
     * System.out.println(MaxRepeat.searchTriplets(new int[]{-3, 0, 1, 2, -1, 1,
     * -2}));
     * System.out.println(MaxRepeat.searchTriplets(new int[]{-5, 2, -1, -2, 3}));
     * }
     */

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(arr);
        // : Write your code here
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            searchPairs(arr, -arr[i], i + 1, triplets);
        }
        return triplets;
    }

    public static int searchTriplet(int[] arr, int target) {
        int closestSum = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int diff = target - arr[i] - arr[left] - arr[right];
                if (diff == 0)
                    return target;
                if (Math.abs(diff) < Math.abs(closestSum)
                        || (Math.abs(diff) == Math.abs(closestSum) && diff > closestSum))
                    closestSum = diff;
                if (diff > 0)
                    left++;
                else
                    right--;

            }
        }

        return target - closestSum;
    }

    /*
     * public static void main(String[] args) {
     * System.out.println(MaxRepeat.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
     * System.out.println(MaxRepeat.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
     * System.out.println(MaxRepeat.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
     * }
     */
    static int closetSum(int[] arr, int targetsum, int left, int closestSum) {
        int right = arr.length - 1;

        while (left < right) {
            int cSum = arr[left] + arr[right];
            if (left < right && targetsum == cSum) {
                return 0;

            } else if (targetsum > cSum) {
                left++;
            } else {
                right--;
            }
        }
        return closestSum;
    }

    static void searchPairs(int[] arr, int targetsum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right) {
            int cSum = arr[left] + arr[right];
            if (left < right && targetsum == cSum) {
                triplets.add(Arrays.asList(-targetsum, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[right] == arr[right + 1]) {
                    right--;
                }
                while ((left < right) && arr[left] == arr[left - 1]) {
                    left++;
                }
            } else if (targetsum > cSum) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static int searchTripletsCount(int[] arr, int target) {
        int count = 0;
        // : Write your code here
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int lt = i + 1;
            int rt = arr.length - 1;
            while (lt < rt) {
                int cSum = arr[i] + arr[lt] + arr[rt];
                if (cSum < target) {
                    for (int j = rt; j > lt; j--) {
                        System.out.println(arr[i] + "," + arr[lt] + "," + arr[j]);
                        // System.out.println(arr[i]+","+arr[lt]+","+arr[rt]);
                        count++;
                    }

                    lt++;
                } else {
                    rt--;
                }

            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("---");
        System.out.println(TwoPointer.searchTripletsCount(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println("Count : - : " + TwoPointer.searchTripletsCount(new int[] { -1, 4, 2, 1, 3 }, 5));

    }
}