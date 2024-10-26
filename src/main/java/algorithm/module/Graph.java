package algorithm.module;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    private List<List<Integer>> adjList;

    public Graph(int nodeNumber) {
        adjList = new ArrayList<>();
        for (int i = 0; i < nodeNumber; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void printGraph() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " : ");
            for (int v : adjList.get(i)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public void dfs(int start, boolean[] visited) {
        visited[start] = true;
        for (int v : adjList.get(start)) {
            if (!visited[v]) {
                visited[v] = true;
                dfs(v, visited);
            }
        }
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int v : adjList.get(node)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }
}
