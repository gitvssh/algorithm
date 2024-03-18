package algorithm.baek.cumulativesum;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/12847
 * 꿀 아르바이트
 * 누적합
 */
public class HoneyAlba implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer((br.readLine()));
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        long[] sum = new long[n + 1];
        st = new StringTokenizer((br.readLine()));
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }
        long max = 0;
        for (int i = m; i <= n; i++) {
            max = Math.max(max, sum[i] - sum[i - m]);
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
