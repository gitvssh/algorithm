package algorithm.baek.recursive;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

public class FibonacciCount implements TestCase {

    public static Integer[][] dp = new Integer[41][2];
    public static int[] dp2 = new int[41];

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp2[0] = 1;
        dp2[1] = 1;

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            Integer[] fibonacci = fibonacci(n);
            bw.write(fibonacci[0] + " " + fibonacci[1] + "\n");
            bw.write(fibonacci2(n) + "\n");
        }
        bw.close();
    }

    public Integer[] fibonacci(int n) {
        if (dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }
        return dp[n];
    }

    public int fibonacci2(int n) {
        if (dp2[n] == 0) {
            dp2[n] = fibonacci2(n - 1) + fibonacci2(n - 2);
        }
        return dp2[n];
    }
}
