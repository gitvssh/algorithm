package algorithm.baek.dfs;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Zelda implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();
            String problem = "Problem";

            int n = Integer.parseInt(br.readLine());
            int tc = 0;
            while (n != 0) {
                tc++;
                Map map = new Map(n);
                map.init(br);
                sb.append(problem).append(" ").append(tc).append(": ").append(map.getResult()).append("\n");
                n = Integer.parseInt(br.readLine());
            }
            bw.write(sb.toString());
        }
    }
}

class Map {

    private int[][] map;
    private int minResult;
    private int[][] dirs = {{0, 1}, {1, 0},{0, -1}, {-1, 0}};

    Map(int n) {
        map = new int[n][n];
    }

    public void init(BufferedReader br) throws IOException {
        int n = map.length;
        minResult = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
    }

    public int getStart(){
        return map[0][0];
    }

    public void dfs(int x, int y, int sum, boolean[][] visited) {
        visited[y][x] = true;
        int n = map.length;
        if (x == n - 1 && y == n - 1) {
            minResult = Math.min(minResult, sum);
            visited[y][x] = false;
            return;
        }
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }
            if (!visited[ny][nx]) {
                dfs(nx, ny, sum + map[ny][nx], visited);
            }
        }
        visited[y][x] = false;
    }

    public int getResult() {
        return bfs();
    }
    private int bfs() {
        int n = map.length;
        int[][] minCost = new int[n][n];
        for (int[] row : minCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minCost[0][0] = map[0][0];
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0, 0, map[0][0]));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.x;
            int y = current.y;
            int cost = current.cost;

            if (x == n - 1 && y == n - 1) {
                return cost;
            }

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    int newCost = cost + map[ny][nx];
                    if (newCost < minCost[ny][nx]) {
                        minCost[ny][nx] = newCost;
                        queue.offer(new Node(nx, ny, newCost));
                    }
                }
            }
        }
        return -1;
    }
}

class Node implements Comparable<Node> {
    int x, y, cost;

    Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost;
    }
}