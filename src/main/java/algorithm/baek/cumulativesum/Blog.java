package algorithm.baek.cumulativesum;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/21921
 * 블로그
 * 누적합
 */
public class Blog implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer((br.readLine()));
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];
        st = new StringTokenizer((br.readLine()));
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }
        int[] cnt = new int[n - x + 2];
        int max = 0;
        for (int i = x; i <= n; i++) {
            cnt[i - x + 1] = sum[i] - sum[i - x];
            max = Math.max(max, cnt[i - x + 1]);
        }
        int rst = 0;
        for (int i = 1; i <= n - x + 1; i++) {
            if (cnt[i] == max) {
                rst++;
            }
        }
        if (max == 0) {
            bw.write("SAD");
        } else {
            bw.write(String.valueOf(max));
            bw.newLine();
            bw.write(String.valueOf(rst));
        }
        bw.flush();
        bw.close();
    }
}
