package algorithm.baek.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class Map {

    int[][] map;
    boolean[] visited;

    public Map(int n) {
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
    }

    public void addVertex(int u, int v) {
        map[u][v] = 1;
        map[v][u] = 1;
    }

    public void chekckVisitedVertex(int v) {
        visited[v] = true;
    }

    public boolean isVisited(int v) {
        return visited[v];
    }

    public boolean isConnected(int v1, int v2) {
        return map[v1][v2] == 1;
    }

    public void dfs(int v) {
        visited[v] = true;
        for (int i = 0; i < map[v].length; i++) {
            if (visited[i]) {
                continue;
            }
            if (map[v][i] == 1) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

    public void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            visited[cur] = true;
            for (int i = 0; i < map[cur].length; i++) {
                if (visited[i]) {
                    continue;
                }
                if (map[cur][i] == 1) {
                    queue.add(i);
                }
            }
        }
    }

    public int bfs(int v, Consumer<Integer> action) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        int count = 0;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            if(visited[cur]) continue;
            visited[cur] = true;
            count++;
            for (int i = 0; i < map[cur].length; i++) {
                if (!visited[i] && map[cur][i] == 1) {
                    queue.add(i);
                }
            }
        }
        return count;
    }

    public int getConnectedCount(int i, Consumer<Integer> o) {
        return bfs(1, o);
    }
}
