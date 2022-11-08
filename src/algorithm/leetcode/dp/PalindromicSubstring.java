package algorithm.leetcode.dp;

import algorithm.TestCase;

import java.text.ParseException;

public class PalindromicSubstring implements TestCase {
    public String longestPalindrome(String s) {

        int len = s.length();
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return s;
        }
        int maxLen = 1;
        int start = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }
        for (int l = 3; l <= len; l++) {
            for (int i = 0; i < len - l + 1; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLen = l;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    @Override
    public void test() throws ParseException {

    }
}
