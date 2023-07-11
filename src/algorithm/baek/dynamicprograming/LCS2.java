package algorithm.baek.dynamicprograming;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/9252
 * LCS2
 */
public class LCS2 implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int length = dp[a.length()][b.length()];
        System.out.println(length);

        if (length > 0) {
            int i = a.length();
            int j = b.length();
            StringBuilder sb2 = new StringBuilder();
            while (length > 0) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    sb2.append(a.charAt(i - 1));
                    i--;
                    j--;
                    length--;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
            System.out.println(sb2.reverse().toString());
        }
    }
}
