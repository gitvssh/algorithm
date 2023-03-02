package algorithm.baek.dynamicprograming;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/11053
 * 가장 긴 증가하는 부분 수열
 */
public class IncreaseSequence implements TestCase {
    static int[] arr;
    static Integer[] dp;
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new Integer[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        for (int i = 0; i < n; i++) {
            recur(i);
        }
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    public static int recur(int n) {
        if (dp[n] == null){
            dp[n] = 1;
            for (int i = n-1; i >=0 ; i--) {
                if (arr[i] < arr[n]){
                    dp[n] = Math.max(dp[n], recur(i) + 1);
                }
            }
        }
        return dp[n];
    }
}
