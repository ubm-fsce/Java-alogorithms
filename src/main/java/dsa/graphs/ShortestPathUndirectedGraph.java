package dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUndirectedGraph {

    void shortestPath(ArrayList<ArrayList<Integer>> adj, int N, int src) {
        int dist[] = new int[N];
        for (int i = 0; i < N; i++)
            dist[i] = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        dist[src] = 0;
        q.offer(src);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int it : adj.get(node)) {
                if (dist[node] + 1 < dist[it]) {
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }
        System.out.println("The distances from source " + src + " are : ");
        for (int i = 0; i < N; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String args[]) {
        int n = 12;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(1).add(4);
        adj.get(2).add(6);
        adj.get(4).add(5);
        adj.get(6).add(3);
        adj.get(4).add(1);
        adj.get(7).add(2);
        adj.get(10).add(4);
        adj.get(11).add(5);
        adj.get(6).add(6);
        adj.get(4).add(3);
        ShortestPathUndirectedGraph obj = new ShortestPathUndirectedGraph();
        obj.shortestPath(adj, n, 0);
    }

}