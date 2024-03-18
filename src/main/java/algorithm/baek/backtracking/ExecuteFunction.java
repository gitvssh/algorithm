package algorithm.baek.backtracking;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class ExecuteFunction implements TestCase {
    static int[][][] dp = new int[21][21][21];

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if (n == -1 && m == -1 && l == -1) break;
            sb.append("w(").append(n).append(", ").append(m).append(", ").append(l).append(") = ");
            sb.append(dfs(n, m, l)).append("\n");
        }
        System.out.println(sb);
    }

    private int dfs(int n, int m, int l) {
        if (inRange(n, m, l) && dp[n][m][l] != 0) return dp[n][m][l];
        if (n <= 0 || m <= 0 || l <= 0) {
            return 1;
        }
        if (n > 20 || m > 20 || l > 20) {
            return dp[20][20][20] = dfs(20, 20, 20);

        }
        if (n < m && m < l) {
            return dp[n][m][l] = dfs(n, m, l - 1) + dfs(n, m - 1, l - 1) - dfs(n, m - 1, l);
        }
        return dp[n][m][l] = dfs(n - 1, m, l) + dfs(n - 1, m - 1, l) + dfs(n - 1, m, l - 1) - dfs(n - 1, m - 1, l - 1);
    }

    static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}
