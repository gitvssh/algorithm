package algorithm.baek.cumulativesum;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13900
 * 순서쌍의 곱의 합
 * 누적합
 */
public class MultipleSum implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer((br.readLine()));
        long[] arr = new long[n + 1];
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }

        long rst = 0;
        for (int i = 1; i <= n; i++) {
            rst += arr[i] * (sum[n] - sum[i]);
        }
        bw.write(String.valueOf(rst));
        bw.flush();
        bw.close();
    }
}
