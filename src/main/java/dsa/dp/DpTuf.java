package dsa.dp;

import java.util.Arrays;

public class DpTuf {

  public static int fibonacciMemoizatiion_1(int n, int[] dp) {
    if (n <= 1)
      return n;
    if (dp[n] != -1)
      return dp[n];
    return fibonacciMemoizatiion_1(n - 1, dp) + fibonacciMemoizatiion_1(n - 2, dp);
    // Time Complexity: O(N) // Space Complexity: O(N)
  }

  public static int fibonacciTabulation_1(int n, int[] dp) {
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
    // Time Complexity: O(N) // Space Complexity: 2*O(N)
  }

  public static int fibonacciTabulationWithSpaceOptimisation_1(int n) {
    int prev2 = 0;
    int prev = 1;
    int curr = 0;
    for (int i = 2; i <= n; i++) {
      curr = prev + prev2;
      prev2 = prev;
      prev = curr;
    }
    return prev;
    // Time Complexity: O(N) // Space Complexity: 2*O(N)
  }

  public static void main(String[] args) {
    int n = 7;
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    System.out.println(n + "'s fibonacci Number from Memoizatiion is :  " + fibonacciMemoizatiion_1(n, dp));
    System.out.println(n + "'s fibonacci Number from Tabulation is :  " + fibonacciTabulation_1(n, dp));
    System.out.println(
        n + "'s fibonacci Tabulation With Space Optimisation :  " + fibonacciTabulationWithSpaceOptimisation_1(n));
  }
}