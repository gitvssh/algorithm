package algorithm.baek.backtracking;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15663
 * N과 M (9)
 */
public class NM9 implements TestCase {
    static int n;
    static int m;
    static int arr[];
    static int result[];

    static boolean visited[];

    static StringBuilder sb = new StringBuilder();

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        result = new int[m];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.print(sb);
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }

            return;
        }
        int before = -1;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (before == arr[i]) continue;
            before = arr[i];
            visited[i] = true;
            result[depth] = arr[i];
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}
