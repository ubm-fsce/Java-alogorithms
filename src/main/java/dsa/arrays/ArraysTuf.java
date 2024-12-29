package dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraysTuf {

    public static void main(String[] args) {

        for(int i = 1; i<=5; i++){
            for(int j=1; j<=i;j++){
                System.out.print(i);
            }
            System.out.println();
        }

//        int[] arr;
//        // System.out.println(isAnagram("anagram", "nagaram"));
//        // System.out.println(isPalindrome( "A man, a plan, a canal: Panama"));
//        // System.out.println(isValid("()"));
//        arr = new int[] { 1, 3, 2, 5, 4 };
//        int[] arr1 = new int[] { 1, 1, 2, 2, 4, 7, 7 };
//        int[] arr2 = new int[] { 1, 2, 2, 0, 0, 0 };
//        // largestElemenentInArray(arr);
//        // _2ndLargestAndSmallestElements(arr);
//        // isArraySorted(arr2);
//        // removeDuplicates(arr);
//        // leftRotateArrayBy1(arr);
//        // unionOfTwoArrays(arr, arr1);
//        // getSingleItemDoubleOccuringArray(arr1);
//        sortArrayOf012s(arr2);
    }

    public static void sortArrayOf012s(int arr[]) {
        Map<Integer, Long> countMap = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
        int zeroCount = countMap.get(0).intValue();
        int oneCount = countMap.get(1).intValue();
        int twoCount = countMap.get(2).intValue();
        for (int i = 0; i < arr.length; i++) {
            if (zeroCount > 0) {
                arr[i] = 0;
                zeroCount--;

            } else if (oneCount > 0) {
                arr[i] = 1;
                oneCount--;
                continue;
            } else if (twoCount > 0) {
                arr[i] = 2;
                twoCount--;
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void getSingleItemDoubleOccuringArray(int[] arr) {

        // Streams Apprach
        int so = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).findFirst().map(Map.Entry::getKey).get();
        System.out.println("Single Occurance : " + so);

        // Approach 2
        List<Integer> dl = new ArrayList<>();

        Arrays.stream(arr).boxed().forEach(System.out::println);

    }

    public static void unionOfTwoArrays(int[] a, int[] b) {
        // Approach 1 Streams
        System.out.println("STREAM SOLUTION!!!!");
        Stream.concat(Arrays.stream(a).boxed(), Arrays.stream(b).boxed())
                .collect(Collectors.toSet()).forEach(System.out::print);
        // Approach 1 NON Streams
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : a) {
            set.add(i);
        }
        for (int j : b) {
            set.add(j);
        }
        System.out.println("\nNON STREAM SOLUTION!!!!");
        set.forEach(System.out::print);

    }

    public static void rotateElementsByNPlaces(int arr[], int n) {
        // LeftRotateBy NElements
        int[] tarr = new int[n];
        int len = arr.length;
        if (len == 0)
            return;

        n = n % len;
        if (n > len)
            return;
        int sp = len - n;
        for (int i = sp; i < len; i++) {
            tarr[i - sp] = arr[i];
        }

    }

    public static void getLongestSumArray(int[] arr, int sum) {
        int len = arr.length;
        Map<Long, Integer> psm = new HashMap<>();
        long tsum = 0;
        int maxlen = 0;
        for (int i = 0; i < len; i++) {
            tsum += arr[i];
            if (tsum == sum)
                Math.max(maxlen, i + 1);
            long rem = tsum - sum;
            if (psm.containsKey(rem)) {
                int clen = i - psm.get(rem);
                maxlen = Math.max(maxlen, clen);
            }
            if (!psm.containsKey(tsum)) {
                psm.put(tsum, i);

            }
        }

        System.out.println("MaxLength : with given sum " + sum + " is : " + maxlen);
    }

    public static void leftRotateArrayBy1(int[] arr) {
        // Approach 1 with additional space =>O(N) TC O(N)
        int len = arr.length;
        int[] tArr = new int[len];
        for (int i = 1; i < arr.length; i++) {
            tArr[i - 1] = arr[i];
        }
        tArr[len - 1] = arr[0];
        System.out.println(" Approach 1:  leftRotateArrayBy1 Source Arr :==>");
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println(" Approach 1 : leftRotateArrayBy1 modified Arr :==>");
        Arrays.stream(tArr).forEach(System.out::print);
        // Approach 2 with out using additional Space=> O(1)
        System.out.println(" Approach 2:   leftRotateArrayBy1 Source Arr :==>");
        Arrays.stream(arr).forEach(System.out::print);
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
        System.out.println(" Approach 2:  leftRotateArrayBy1 modified Arr :==>");
        Arrays.stream(arr).forEach(System.out::print);

    }

    public static void removeDuplicates(int[] arr) {
        // Approach 1 Streams and collect to a treeSet
        System.out.println(" Stream Approah Start Approach 1!! ");

        Arrays.stream(arr).boxed().collect(Collectors.toCollection(TreeSet::new)).forEach(System.out::println);

        System.out.println(" Stream Approah END Approach 1!!");
        // Approach 1 NONStreams and collect to a treeSet
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i : arr) {
            ts.add((Integer) i);
        }
        System.out.println("NON Stream Approah Start Approach 1 !!");
        ts.forEach(System.out::println);
        System.out.println("NON Stream Approah ENDApproach 1  !!");
        // Approach 2 ponter approach
        int nextPos = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[nextPos]) {
                nextPos++;
                arr[nextPos] = arr[i];
            }
        }
        System.out.println("Approach 2!!: BEGIN ");
        Arrays.stream(arr).boxed().limit(nextPos + 1).forEach(System.out::println);
        System.out.println("Approach 2!!: END ");
    }

    public static void isArraySorted(int[] arr) {
        // Approach 1 : check prev index is greater than current
        boolean isSorted = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                isSorted = false;
                break;
            }
        }
        System.out.println("is ArraysSorted?: " + isSorted);
        // Approach 1 : streams way check prev index is greater than current
        System.out.println("STREAMS APPROACH : ArraysSorted ? : " +
                Arrays.stream(arr).reduce((x, y) -> {
                    if (x > y) {
                        throw new IllegalArgumentException("FALSE!!!");
                    }
                    return y;
                }).isPresent());
    }

    public static void _2ndLargestAndSmallestElements(int[] arr) {
        // Approach 1 : sort and return and 2ndLastIndex and at 2nd position
        Arrays.sort(arr);
        System.out.println(" 2nd largest element sort Approach: " + arr[arr.length - 2]);
        System.out.println(" 2nd smallest element sort Approach: " + arr[1]);
        // Using Streams
        // Smallest
        System.out.println(" 2nd smallest element streams sort Approach: " +
                Arrays.stream(arr).boxed().sorted().skip(1)
                        .findFirst().orElseThrow(null));
        //
        System.out.println(" 2nd largest element streams sort Approach: " +
                Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1)
                        .findFirst().orElseThrow(null));

        // Approach 2 : 1 iterations to getLarge/Small then 2nd iteration for 2nd large
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        // FirstIteration get max and min Values
        for (int i : arr) {
            max1 = Math.max(max1, i);
            min1 = Math.min(min1, i);
        }
        for (int i : arr) {
            if (i != max1)
                max2 = Math.max(max2, i);
            if (i != min1)
                min2 = Math.min(min2, i);
        }
        System.out.println("2 LOOPs Approach:==> Max2: " + max2 + ", and Min2: " + min2);

        // Approach 3 : Single Iteration
        for (int i : arr) {
            if (i > max1) {
                max2 = max1;
                max1 = i;
            } else if (i > max2 && i != max1) {
                max2 = i;
            }
            if (i < min1) {
                min2 = min1;
                min1 = i;
            } else if (i < min2 && i != min1) {
                min2 = i;
            }
        }
        System.out.println("Single loop Approach:==> Max2: " + max2 + ", and Min2: " + min2);

    }

    public static void largestElemenentInArray(int[] arr) {
        // Largest Element in Array
        // Option 1: sort and retrurn last element in Array
        Arrays.sort(arr);
        System.out.println(arr[arr.length - 1]);
        // Option 2 using streams
        int max2 = Arrays.stream(arr).reduce(Integer.MIN_VALUE, (x, y) -> x < y ? y : x);
        System.out.println(max2);
        // Option 3 Largest Element in Array
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = arr[i] < max ? max : arr[i];
        }
        System.out.println(max);
    }

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (st.empty() || st.pop() != map.get(ch)) {
                    return false;
                }
            } else {
                st.push(ch);
            }
        }
        return st.empty();

    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        char[] car = s.toCharArray();
        int len = car.length;
        for (int i = 0; i < len; i++) {
            if (Character.isLetterOrDigit(car[i])) {
                sb.append(car[i]);
            }
        }
        String fstr = sb.toString().toLowerCase();
        int last = fstr.length() - 1;
        int first = 0;
        while (first < last) {
            if (fstr.charAt(first) != fstr.charAt(last)) {
                return false;
            }
            first++;
            last--;
        }
        return true;

    }

    public static boolean isAnagram(String s, String t) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        if (s.length() != t.length()) {
            return false;
        }
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < length; i++) {
            Character ch = t.charAt(i);
            if (!map.containsKey(ch)) {
                return false;
            } else {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
            }
        }
        return map.size() == 0;
    }

}
