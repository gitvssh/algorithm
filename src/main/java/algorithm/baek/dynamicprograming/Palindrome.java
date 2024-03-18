package algorithm.baek.dynamicprograming;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

public class Palindrome implements TestCase {

    static boolean[][] dp;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] array = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(array[i]);
        }

        int tc = Integer.parseInt(br.readLine());
        findPalindrome(arr);
        for (int i = 0; i < tc; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            if (dp[start - 1][end - 1]) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static void findPalindrome(int[] arr) {
        int len = arr.length;
        dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
            }
        }
        for (int l = 3; l <= len; l++) {
            for (int i = 0; i < len - l + 1; i++) {
                int j = i + l - 1;
                if (arr[i] == arr[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

    }
}
