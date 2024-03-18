package algorithm.baek.dynamicprograming;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11403
 * 경로 찾기
 * 플로이드 와샬 알고리즘
 * 중간 경로를 중심으로, 경로가 있는지 확인 or 최단 경로를 찾는다.
 */
public class FindPath implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = arr[i][j];
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
//                    if (arr[i][j] == 1 && arr[j][k] == 1) {
                    if (dp[i][j] + dp[j][k] < dp[i][k]) {
                        dp[i][k] = dp[i][j] + dp[j][k];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(dp[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
