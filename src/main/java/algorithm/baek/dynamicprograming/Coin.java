package algorithm.baek.dynamicprograming;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9084
 * 동전
 */
public class Coin implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] coins;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            coins = new int[N];
            for (int j = 0; j < N; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }

            int target = Integer.parseInt(br.readLine());

            int[] dp = new int[target + 1];

            Arrays.sort(coins);
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > target) {
                    break;
                }
                dp[coins[j]]++;
                for (int k = coins[j] + 1; k < dp.length; k++) {
                    dp[k] += dp[k - coins[j]];
                }
            }

            bw.write(dp[target] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
