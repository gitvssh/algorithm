package algorithm.baek.dynamicprograming;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

public class Padoban implements TestCase {
    public static long[] dp = new long[102];

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for (int i = 6; i < dp.length; i++) {
            dp[i] = -1;
        }
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(p(n) + "\n");
        }
        bw.close();
    }

    private long p(int n) {
        if (dp[n] == -1) {
            dp[n] = p(n - 1) + p(n - 5);
        }
        return dp[n];
    }
}
