package algorithm.baek.dynamicprograming;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class Tiles implements TestCase {
    public static int[] dp = new int[1000001];
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = -1;
        }

        System.out.println(tiles(n));
    }

    private int tiles(int n) {
        if(dp[n] == -1){
            dp[n] = (tiles(n-1) + tiles(n-2)) % 15746;
        }
        return dp[n];
    }
}
