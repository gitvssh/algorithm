package algorithm.baek.dynamicprograming;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/24723
 * 녹색거탑
 */
public class GreenTop implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        n++;
        int[][] dp = new int[n+1][n+1];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) dp[i][j] = 1;
                else if (j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += dp[n-1][i];
        }
        System.out.println(sum);
    }
}
