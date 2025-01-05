package dsa.graphs;

class Bipartite {
  public boolean isBipartite(int[][] graph) {
    int rows = graph.length;
    int[] colors = new int[rows];

    for (int i = 0; i < rows; i++) {
      if (colors[i] == 0) {
        if (!dfs(i, colors, 1, graph)) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean dfs(int node, int[] colors, int color, int[][] graph) {
    colors[node] = color;

    for (int i = 0; i < graph[node].length; i++) {
      int neighbour = graph[node][i];
      if (colors[neighbour] == 0) {
        if (!dfs(neighbour, colors, -color, graph)) {  // Use -color instead of color flip logic
          return false;
        }
      } else if (colors[neighbour] == color) {  // Compare with current color
        return false;
      }
    }
    return true;
  }
}