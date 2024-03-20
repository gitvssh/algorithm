package algorithm.baek.dynamicprograming;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FibonacciSimilar implements TestCase {

    static long[] dp = new long[117];

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        log.info("result : {}", fibonacci(n));
    }

    public static long fibonacci(int n) {
        if(n == 0) {
            return 0;
        } else if(n == 1 || n == 2 || n == 3) {
            return dp[n];
        } else {
            if(dp[n] != 0) {
                return dp[n];
            }else{
                return dp[n] = fibonacci(n - 1) + fibonacci(n - 3);
            }
        }
    }
}
