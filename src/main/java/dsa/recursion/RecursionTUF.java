package dsa.recursion;

import java.util.ArrayList;

public class RecursionTUF {

    public static void subSequenceSum(
            ArrayList<ArrayList<Integer>> ans,
            int a[], ArrayList<Integer> temp,
            int k, int start) {
        System.out.println(" k " + k + " : start : " + start + " temp : " + temp);
        if (start == a.length || k <= 0) {
            if (k == 0) {
                ans.add(
                        new ArrayList<Integer>(temp));
                return;
            }
            return;
        } else {

            temp.add(a[start]);
            subSequenceSum(ans, a,
                    temp, k - a[start], start + 1);
            temp.remove(temp.size() - 1);
            subSequenceSum(ans, a,
                    temp, k - a[start], start + 1);

        }
    }

    // public static void printSubsequences(int[] arr, int index,
    // ArrayList<Integer> path) {

    // if (index == arr.length) {
    // if (path.size() > 0)
    // System.out.println(path);
    // } else {
    // printSubsequences(arr, index + 1, path);
    // path.add(arr[index]);
    // printSubsequences(arr, index + 1, path);
    // path.remove(path.size() - 1);
    // }
    // return;
    // }

    // Driver Code
    public static void main(String args[]) {
        int arr[] = { 5, 1, 3, 2 };
        int k = 6;
        ArrayList<ArrayList<Integer>> ans;
        ans = new ArrayList<ArrayList<Integer>>();
        subSequenceSum(ans, arr,
                new ArrayList<Integer>(), k, 0);
        System.out.println(" Size : " + ans.size());
        // Loop to print the subsequences
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
        // Auxiliary space to store each path
        System.out.println("=====================printSubsequences==============");
        ArrayList<Integer> path = new ArrayList<>();
        // printSubsequences(arr, 0, path);

    }
}