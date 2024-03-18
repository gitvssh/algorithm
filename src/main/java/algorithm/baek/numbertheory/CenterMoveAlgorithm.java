package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/2903
 * 중앙 이동 알고리즘
 */
public class CenterMoveAlgorithm implements TestCase {
    static int[] dp;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[0] = 2;
        System.out.println((int) (Math.pow((solve(n)), 2)));
    }

    public static int solve(int n) {
        if (dp[n] != 0) return dp[n];
        return dp[n] = 2 * solve(n - 1) - 1;
    }
}
