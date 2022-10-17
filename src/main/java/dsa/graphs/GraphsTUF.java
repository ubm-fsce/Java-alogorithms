package dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
  int first;
  int prev;

  public Pair(int first, int prev) {
    this.first = first;
    this.prev = prev;
  }

}

public class GraphsTUF {
  // 1. bfsOfGraph
  public static ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adjList) {
    // v: vortex length or node length
    ArrayList<Integer> bfs = new ArrayList<>();
    boolean visited[] = new boolean[v];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    visited[0] = true;
    while (!queue.isEmpty()) {
      Integer node = queue.poll();
      bfs.add(node);
      // Get all adjacent vertices of the dequeued vertex s
      // If a adjacent has not been visited, then mark it
      // visited and enqueue it

      for (Integer it : adjList.get(node)) {
        if (visited[it] == false) {
          visited[it] = true;
          queue.add(it);
        }
      }
    }
    return bfs;
  }

  // 2. DFS of Graph
  public static ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adjList) {
    ArrayList<Integer> dfs = new ArrayList<>();
    boolean visited[] = new boolean[v];
    visited[0] = true;
    dfsRecursion(0, adjList, visited, dfs);
    return dfs;

  }

  static void dfsRecursion(int v, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, ArrayList<Integer> dfs) {
    visited[v] = true;
    dfs.add(v);
    for (Integer it : adjList.get(v)) {
      if (visited[it] == false) {
        dfsRecursion(it, adjList, visited, dfs);
      }
    }
  }

  // 3. Cycle Detection in Undirected Graph using bfs
  static boolean hasCycleBFS(int v, ArrayList<ArrayList<Integer>> adjList) {
    boolean visited[] = new boolean[v];
    // Arrays.fill(visited, false); no need as booelan array defaults to false.
    // Note :Object (Boolean)defautls to null and boolean defaults to false.
    for (int i = 0; i < v; i++) {
      if (visited[i] == false) {
        if (checkforCycle(adjList, i, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  static boolean checkforCycle(ArrayList<ArrayList<Integer>> adjList, int v, boolean[] visited) {
    Queue<Pair> que = new LinkedList<>();
    que.add(new Pair(v, -1));
    visited[v] = true;
    while (!que.isEmpty()) {
      Pair currPair = que.poll();
      int node = currPair.first;
      int prev = currPair.prev;
      for (Integer it : adjList.get(node)) {
        if (visited[it] == false) {
          que.add(new Pair(it, node));
          visited[it] = true;
        } else if (prev != it) {
          return true;
        }
      }
    }
    return false;
  }

  // 4. Cycle Detection in Undirected Graph using DFS
  public static boolean hasCycleDFS(int v, ArrayList<ArrayList<Integer>> adjList) {
    boolean visited[] = new boolean[v];
    // Arrays.fill(visited, false);
    visited[0] = true;
    Pair cpair = new Pair(0, -1);
    if (dfshasCycleCheck(cpair, adjList, visited)) {
      return true;
    }
    return false;
  }

  static boolean dfshasCycleCheck(Pair cpair, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
    int node = cpair.first;
    int prev = cpair.prev;
    visited[node] = true;
    for (Integer it : adjList.get(node)) {
      if (visited[it] == false) {
        if (dfshasCycleCheck(new Pair(it, node), adjList, visited) == true) {
          return true;
        }
      } else if (prev != it) {
        return true;
      }
    }
    return false;
  }

  // ### DFS BIPartite
  static boolean checkBipartiteDFS(ArrayList<ArrayList<Integer>> adjList, int v) {
    int color[] = new int[v];
    Arrays.fill(color, -1);
    for (int i = 0; i < v; i++) {
      if (color[i] == -1) {
        if (dfsBipartiteCheck(adjList, i, color)) {
          return false;
        }
      }
    }
    return true;
  }

  // ### DFS BIPartite
  static boolean dfsBipartiteCheck(ArrayList<ArrayList<Integer>> adjList, int v, int color[]) {
    for (Integer it : adjList.get(v)) {
      if (color[it] == -1) {
        color[it] = 1 - color[v];
        if (!dfsBipartiteCheck(adjList, it, color)) {
          return false;
        } else if (color[it] == color[v]) {
          return false;
        }
      }
    }
    return true;
  }

  // ### BFS BIPartite
  public static boolean isBipartiteBFS(ArrayList<ArrayList<Integer>> adjList, int v) {
    int color[] = new int[v];
    Arrays.fill(color, -1);
    for (int i = 0; i < v; i++) {
      if (color[i] == -1) {
        if (!bipartiteBfsCheck(adjList, i, v, color)) {
          return false;
        }
      }
    }
    return true;

  }

  private static boolean bipartiteBfsCheck(ArrayList<ArrayList<Integer>> adjList,
      int start, int v, int[] color) {
    Queue<Integer> que = new LinkedList<>();
    que.add(start);
    color[start] = 0;
    while (!que.isEmpty()) {
      int node = que.poll();
      for (int it : adjList.get(node)) {
        if (color[it] == -1) {
          color[it] = 1 - color[node];
          que.add(it);
        } else if (color[it] == color[node]) {
          return false;
        }
      }
    }
    return true;
  }

  // ### Plumbing CODE ###
  public static void main(String args[]) {
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      adjList.add(new ArrayList<Integer>());
    }
    adjList.get(0).add(1);
    adjList.get(1).add(0);
    adjList.get(0).add(2);
    adjList.get(2).add(0);
    adjList.get(0).add(3);
    adjList.get(3).add(0);
    adjList.get(2).add(4);
    adjList.get(4).add(2);
    // 1
    printGraph(bfsOfGraph(5, adjList), "1. BFS Graph Traversal");
    // 2
    printGraph(dfsOfGraph(5, adjList), "2. DFS Graph Traversal");
    // 3
    System.out.println("3 : " + hasCycleBFS(5, adjList));
    // 4
    System.out.println("4 : " + hasCycleDFS(5, adjList));
    // 5
    System.out.println("5 : " + checkBipartiteDFS(adjList, 5));
    // 5
    System.out.println("6 : " + isBipartiteBFS(adjList, 5));
  }

  static void printGraph(ArrayList<Integer> ans, String identifier) {
    System.out.println(identifier);
    System.out.println("--------- ");

    for (int i = 0; i < ans.size(); i++) {
      System.out.println(ans.get(i));
    }
    System.out.println("---------");
  }

}