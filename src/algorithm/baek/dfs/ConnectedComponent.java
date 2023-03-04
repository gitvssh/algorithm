package algorithm.baek.dfs;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11724
 * 연결 요소의 개수
 */
public class ConnectedComponent implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
//                dfs(graph, visited, i);
                bfs(graph, visited, i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void bfs(int[][] graph, boolean[] visited, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (!visited[x]) {
                visited[x] = true;
                for (int j = 1; j < graph.length; j++) {
                    if (graph[x][j] == 1 && !visited[j]) {
                        queue.add(j);
                    }
                }
            }
        }
    }

    public static void dfs(int[][] graph, boolean[] visited, int i) {
        if (!visited[i]) {
            visited[i] = true;
            for (int j = 1; j < graph.length; j++) {
                if (graph[i][j] == 1 && !visited[j]) {
                    dfs(graph, visited, j);
                }
            }
        }
    }
}
