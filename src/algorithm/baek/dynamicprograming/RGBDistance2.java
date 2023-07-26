package algorithm.baek.dynamicprograming;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/17404
 * RGB거리 2
 * 다이나믹 프로그래밍
 */
public class RGBDistance2 implements TestCase {
    static int n;
    static int[][] arr;
    static int[][] dp;
    static int result = Integer.MAX_VALUE;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // R
            arr[i][1] = Integer.parseInt(st.nextToken()); // G
            arr[i][2] = Integer.parseInt(st.nextToken()); // B
        }

        // 첫번째 집의 색깔을 정한다.
        for (int startColor = 0; startColor < 3; startColor++) {
            // 첫번째 집의 색깔 외의 색깔은 1000 * 1000 + 1로 초기화하여 선택되지 않도록 한다.
            dp[0][0] = dp[0][1] = dp[0][2] = 1000 * 1000 + 1;
            dp[0][startColor] = arr[0][startColor];

            for (int j = 1; j < n; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + arr[j][2];
            }
            for (int lastColor = 0; lastColor < 3; lastColor++) {
                // 첫번째 집의 색깔과 마지막 집의 색깔이 같은 경우는 제외한다.
                if (startColor == lastColor) continue;
                result = Math.min(result, dp[n - 1][lastColor]);
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
