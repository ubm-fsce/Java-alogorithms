package dsa.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    output.add(new ArrayList<Integer>());

    for (int num : nums) {
      List<List<Integer>> newSubsets = new ArrayList<>();
      for (List<Integer> curr : output) {
        System.out.println("curr  : " + curr);
        newSubsets.add(new ArrayList<Integer>(curr) {
          {
            add(num);
          }
        });
        System.out.println("newSubsets  :==> " + newSubsets);
      }
      for (List<Integer> curr : newSubsets) {
        output.add(curr);
      }
      System.out.println("output  : " + output);
    }
    return output;
  }

  // public class Solution {
  // // Java code to print all possible
  // // subsequences for given array using
  // // recursion

  // // Recursive function to print all
  // // possible subsequences for given array
  // public static void printSubsequences(int[] arr, int index,
  // ArrayList<Integer> path) {
  // // Print the subsequence when reach
  // // the leaf of recursion tree
  // if (index == arr.length) {
  // // Condition to avoid printing
  // // empty subsequence
  // if (path.size() > 0)
  // System.out.println(path);
  // } else {
  // // Subsequence without including
  // // the element at current index
  // printSubsequences(arr, index + 1, path);
  // path.add(arr[index]);
  // // Subsequence including the element
  // // at current index
  // printSubsequences(arr, index + 1, path);
  // // Backtrack to remove the recently
  // // inserted element
  // path.remove(path.size() - 1);
  // }
  // return;
  // }

  // Driver code
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3 };
    // Auxiliary space to store each path
    ArrayList<Integer> path = new ArrayList<>();
    // printSubsequences(arr, 0, path)
    subsets(arr);
  }
}
