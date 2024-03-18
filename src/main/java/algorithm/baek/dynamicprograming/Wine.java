package algorithm.baek.dynamicprograming;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/2156
 * 포도주 시식
 */
public class Wine implements TestCase {
    static Integer[] dp;
    static int[] arr;
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new Integer[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = arr[1];
        if(n>1){
            dp[2] = arr[1] + arr[2];
        }
//        for (int i = 3; i <= n; i++) {
//            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
//        }
//        System.out.println(dp[n]);
        System.out.println(recur(n));
    }

    public static int recur(int n) {
        if (dp[n] == null){
            dp[n] = Math.max(Math.max(recur(n - 2), recur(n - 3) + arr[n - 1]) + arr[n], recur(n - 1));
        }
        return dp[n];
    }
}
