package dsa.graphs;

import java.util.ArrayList;

public class GraphLeetcode {
  public static int findCircleNum(int[][] isConnected) {
    int v = isConnected.length;
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < v; i++) {
      adjList.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < v; i++) {
      for (int j = 0; j < v; j++) {
        System.out.println(i + " | " + j);
        System.out.println("isConnected[i][j] :  " + isConnected[i][j] + " i : " + i + " J : " + j);
        if (isConnected[i][j] == 1 && i != j) {
          System.out.println("Adding to adjList ....");
          adjList.get(i).add(j);
          adjList.get(j).add(i);
        }
      }
    }
    int vis[] = new int[v];
    int cnt = 0;
    for (int i = 0; i < v; i++) {
      if (vis[1] == 0) {
        cnt++;
        dfs(i, adjList, vis);
      }
    }
    return cnt;
  }

  static void dfs(int n, ArrayList<ArrayList<Integer>> adjList, int vis[]) {
    vis[n] = 1;
    for (Integer it : adjList.get(n)) {
      if (vis[it] == 0) {
        dfs(it, adjList, vis);
      }
    }
  }

  public static void main(String[] args) {
    int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
    System.out.println(findCircleNum(isConnected));
  }

}