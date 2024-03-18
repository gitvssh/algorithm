package algorithm.baek.dynamicprograming;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2565
 * 전깃줄
 */
public class ElectronicLine implements TestCase {
    static int[][] wires;
    static Integer[] dp;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        wires = new int[n][2];
        dp = new Integer[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wires[i][0] = Integer.parseInt(st.nextToken());
            wires[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(wires, (o1, o2) -> o1[0] - o2[0]);

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, getDp(i));
        }
        System.out.println(n - max);
    }

    static int getDp(int i) {
        if (dp[i] == null) {
            dp[i] = 1;
            for (int j = i + 1; j < wires.length; j++) {
                if (wires[i][1] < wires[j][1]) {
                    dp[i] = Math.max(dp[i], getDp(j) + 1);
                }
            }
        }
        return dp[i];
    }
}
