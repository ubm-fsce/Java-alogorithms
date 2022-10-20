package dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

  // ### 5. DFS BIPartite
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

  // ### 6.BFS BIPartite
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

  // ### 7. detect a cycle in Directed graph
  public static boolean isDirectedCyclic(int v, ArrayList<ArrayList<Integer>> adjList) {
    int visited[] = new int[v];
    int pathVisited[] = new int[v];
    // Arrays.fill is not reqiured as default Array Initialisation takes care of
    // adding 0's
    for (int i = 0; i < v; i++) {
      if (visited[i] == 0) {
        if (hasCycleInDAG(i, visited, pathVisited, adjList) == true) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean hasCycleInDAG(int i, int[] visited, int[] pathVisited,
      ArrayList<ArrayList<Integer>> adjList) {
    visited[i] = 1;
    pathVisited[i] = 1;
    for (int it : adjList.get(i)) {
      if (visited[i] == 0) {
        if (hasCycleInDAG(it, visited, pathVisited, adjList) == true) {
          return true;
        } else if (pathVisited[it] == 1) {
          return true;
        }
      }
    }
    pathVisited[i] = 0;
    return false;
  }

  // ### 8.TopoSort using DFS
  public static int[] dfsToposort(int v, ArrayList<ArrayList<Integer>> adjList) {
    int[] visited = new int[v];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < v; i++) {
      if (visited[i] == 0) {
        getToposortwithDfs(i, visited, stack, adjList);
      }
    }
    return getArrayFromStack(stack);
  }

  private static void getToposortwithDfs(int i, int[] visited, Stack<Integer> stack,
      ArrayList<ArrayList<Integer>> adjList) {
    visited[i] = 1;
    for (int it : adjList.get(i)) {
      if (visited[it] == 0) {
        getToposortwithDfs(it, visited, stack, adjList);
      }
    }
    stack.push(i);
  }

  private static int[] getArrayFromStack(Stack<Integer> stack) {
    int topoSortedArray[] = new int[stack.size()];
    int ind = 0;
    while (!stack.isEmpty()) {
      topoSortedArray[ind++] = stack.pop();
    }
    return topoSortedArray;
  }

  // 9. Topological Sort BFS Kahn's Alogrithm
  public static int[] toposortDfs(int v, ArrayList<ArrayList<Integer>> adjList) {
    int[] topo = new int[v], inDegree = new int[v];

    Queue<Integer> que = new LinkedList<>();
    // populate indegree array
    for (int i = 0; i < v; i++) {
      for (int it : adjList.get(i)) {
        inDegree[it]++;
      }
    }
    for (int i = 0; i < v; i++) {
      if (inDegree[i] == 0) {
        que.add(i);
      }
    }
    int ind = 0;
    while (!que.isEmpty()) {
      Integer node = que.poll();
      topo[ind++] = node;
      for (Integer it : adjList.get(node)) {
        inDegree[it]--;
        if (inDegree[it] == 0) {
          que.add(it);
        }
      }
    }
    return topo;
  }

  // 10. Cycle detection in DAG kahn's Algorithm
  public static boolean isDAGCylicBFS(int v, ArrayList<ArrayList<Integer>> adjList) {
    int[] indegree = new int[v];
    for (int i = 0; i < v; i++) {
      for (Integer it : adjList.get(i)) {
        indegree[it]++;
      }
    }
    Queue<Integer> que = new LinkedList<>();
    for (int i = 0; i < v; i++) {
      if (indegree[i] == 0) {
        que.add(i);
      }
    }

    int count = 0;
    while (!que.isEmpty()) {
      Integer node = que.poll();
      count++;
      for (Integer it : adjList.get(node)) {
        indegree[it]--;
        if (indegree[it] == 0) {
          que.add(it);
        }
      }

    }
    return (count == v) ? false : true;

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
    System.out.println("3 : hasCycleBFS : " + hasCycleBFS(5, adjList));
    // 4
    System.out.println("4 : hasCycle DFS " + hasCycleDFS(5, adjList));
    // 5
    System.out.println("5 : checkBipartite DFS ? : " + checkBipartiteDFS(adjList, 5));
    // 5
    System.out.println("6 : isBipartiteBFS ? : " + isBipartiteBFS(adjList, 5));
    // 7
    System.out.println("7 : DirectedCyclic DFS ? : " + isDirectedCyclic(5, adjList));
    // 8
    System.out.println("8 : TOPOSORT DFS  : " + Arrays.toString(dfsToposort(5, adjList)));
    // 9
    System.out.println("9 : TOPOSORT BFS  Kahn's Algorithm : " + Arrays.toString(dfsToposort(5, adjList)));
    // 10
    System.out.println("10 : isDAGCylicBFS TOPOSORT  Kahn's Algorithm : " + isDAGCylicBFS(5, adjList));

  }

  static void printGraph(ArrayList<Integer> ans, String identifier) {
    System.out.print(identifier + " : ");
    for (int i = 0; i < ans.size(); i++) {
      if (i != (ans.size() - 1)) {
        System.out.print(ans.get(i) + " => ");
      } else {
        System.out.println(ans.get(i));
      }
    }~
  }

}