package algorithm.baek.dynamicprograming;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class SerialSum implements TestCase {
    static int[] arr;		// 배열
    static Integer[] dp;	// 메모이제이션 할 dp
    static int max;			// 최댓값 변수
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        max = arr[0];

        recur(N - 1);

        System.out.println(max);
    }

    static int recur(int N) {

        if(dp[N] == null) {
            dp[N] = Math.max(recur(N - 1) + arr[N], arr[N]);

            max = Math.max(dp[N], max);
        }

        return dp[N];
    }

    public void dfsVersion() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long[][] sum = new long[n][n];
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum[i][i] = arr[i];
            max = Math.max(max, sum[i][i]);
            for (int j = i + 1; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + arr[j];
                max = Math.max(max, sum[i][j]);
            }
        }
        bw.write(max + "");
        bw.flush();
        bw.close();

    }
}
