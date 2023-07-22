package algorithm.baek.dynamicprograming;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11049
 * 행렬 곱셈 순서
 * dp
 */
public class MatrixMultipleOrder implements TestCase {
    static int n;
    static int[][] dp;
    static int[][] matrix;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][2];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        // dp[i][j] = i번째 행렬부터 j번째 행렬까지의 곱셈 연산 횟수의 최솟값
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = matrix[i][0] * matrix[i][1] * matrix[i + 1][1];
        }

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int k = i + j;
                dp[j][k] = Integer.MAX_VALUE;
                for (int l = j; l < k; l++) {
                    dp[j][k] = Math.min(dp[j][k], dp[j][l] + dp[l + 1][k] + matrix[j][0] * matrix[l][1] * matrix[k][1]);
                }
            }
        }
        bw.write(dp[0][n - 1] + "\n");
        bw.flush();
        bw.close();
    }
}
