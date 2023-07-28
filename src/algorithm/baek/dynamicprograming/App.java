package algorithm.baek.dynamicprograming;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7579
 * 앱
 */
public class App implements TestCase {
    static AppInfo[] apps;
    static int[][] dp;
    static int n;
    static int m;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer((br.readLine()));
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        apps = new AppInfo[n + 1];
        dp = new int[n + 1][10001];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            apps[i] = new AppInfo(Integer.parseInt(st.nextToken()), 0);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            apps[i].cost = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MAX_VALUE;

        // dp[i][j] : i번째 앱까지 j의 비용으로 확보할 수 있는 최대 메모리
        for (int i = 1; i <= n; i++) {
            // 최대비용 n * c = 10000
            for (int j = 0; j <= 10000; j++) {
                //
                if (j >= apps[i].cost) {
                    // 최대 메모리 = 이전 앱까지의 최대 메모리 vs 이전 앱까지의 최대 메모리 + 현재 앱의 메모리
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - apps[i].cost] + apps[i].memory);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                // 최소비용으로 m 이상의 메모리를 확보할 수 있는 경우
                if (dp[i][j] >= m) {
                    result = Math.min(result, j);
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();

    }

    class AppInfo {
        int memory;
        int cost;

        public AppInfo(int memory, int cost) {
            this.memory = memory;
            this.cost = cost;
        }
    }
}
