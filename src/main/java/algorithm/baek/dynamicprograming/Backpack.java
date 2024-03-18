package algorithm.baek.dynamicprograming;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/12865
 * 평범한 배낭
 */
public class Backpack implements TestCase {
    static Integer[][] dp;
    static int[] w;
    static int[] v;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        w = new int[n + 1];
        v = new int[n + 1];
        dp = new Integer[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(backpack(n, k));


    }

    public static int backpack(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if (dp[n][k] != null) {
            return dp[n][k];
        }
        if (w[n] > k) {
            return dp[n][k] = backpack(n - 1, k);
        } else {
            return dp[n][k] = Math.max(backpack(n - 1, k), backpack(n - 1, k - w[n]) + v[n]);
        }
    }
}
