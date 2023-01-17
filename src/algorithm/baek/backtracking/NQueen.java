package algorithm.baek.backtracking;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class NQueen implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[0] = i;
            visited[i] = true;
            cnt += dfs(1, n, arr, visited);
            visited[i] = false;
        }
        System.out.println(cnt);
    }

    private int dfs(int depth, int n, int[] arr, boolean[] visited) {
        if (depth == n) {
            return 1;
        }
        int cnt = 0;
        for (int j = 0; j < n; j++) {
            if (!visited[j]) {
                boolean flag = true;
                for (int k = 0; k < depth; k++) {
                    if (Math.abs(depth - k) == Math.abs(j - arr[k])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    arr[depth] = j;
                    visited[j] = true;
                    cnt += dfs(depth + 1, n, arr, visited);
                    visited[j] = false;
                }
            }
        }
        return cnt;
    }
}
