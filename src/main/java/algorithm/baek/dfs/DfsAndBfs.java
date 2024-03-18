package algorithm.baek.dfs;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1260
 * DFS와 BFS
 */
public class DfsAndBfs implements TestCase {
    static int[][] graph;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        sb = new StringBuilder();
        dfs(v);
        sb.append("\n");
        visited = new boolean[n + 1];
        queue.add(v);
        bfs(v);
        System.out.println(sb.toString());
    }

    public static void bfs(int v) {
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (!visited[x]) {
                visited[x] = true;
                sb.append(x + " ");
                for (int i = 1; i < graph.length; i++) {
                    if (graph[x][i] == 1 && !visited[i]) {
                        queue.add(i);
                    }
                }
            }
        }
    }

    public static void dfs(int v) {
        visited[v] = true;
        sb.append(v + " ");
        for (int i = 1; i < graph.length; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
