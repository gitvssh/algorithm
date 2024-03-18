package algorithm.baek.backtracking;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

public class NM3 implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        dfs(n, m, 0, arr, sb);
        System.out.println(sb);
    }

    private void dfs(int n, int m, int depth, int[] arr, StringBuilder sb) {
        if (m == depth) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[j]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int j = 0; j < n; j++) {
            arr[depth] = j + 1;
            dfs(n, m,depth + 1, arr, sb);
        }
    }
}
