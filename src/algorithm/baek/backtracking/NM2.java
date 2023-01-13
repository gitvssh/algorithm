package algorithm.baek.backtracking;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class NM2 implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
    int n;
    int m;
    int[] arr;
    boolean[] visited;

    StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n];
        dfs(0, 0, n, m, arr, visited, sb);
        System.out.println(sb);
    }

    public static void dfs(int depth, int before, int n, int m, int[] arr, boolean[] visited, StringBuilder sb) {
        if (depth == m) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[j]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int j = 0; j < n; j++) {
            if (before > j) continue;
            if (!visited[j]) {
                visited[j] = true;
                arr[depth] = j + 1;
                dfs(depth + 1, j, n, m, arr, visited, sb);
                visited[j] = false;
            }
        }
    }
}