package algorithm.baek.cumulativesum;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2003
 * 수들의 합 2
 * 누적합
 */
public class SumOfNumber implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer((br.readLine()));
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n + 1];
        long[] sum = new long[n + 1];
        st = new StringTokenizer((br.readLine()));
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (sum[j] - sum[i - 1] == m) {
                    cnt++;
                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
