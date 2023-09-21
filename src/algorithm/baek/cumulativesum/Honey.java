package algorithm.baek.cumulativesum;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/21758
 * 꿀
 * 누적합
 */
public class Honey implements TestCase {
    static int n;
    static int[] honey;
    static long[] sum;
    static long total;
    static long max;
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer((br.readLine()));
        honey = new int[n + 1];
        sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + honey[i];
        }

        max = 0;
        setToLeft();
        setToRight();
        setToMiddle();

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    static void setToLeft() {
        for(int i = 2; i<n; i++){
            max = Math.max(max, sum[n] - honey[1] - honey[i] + sum[n] - sum[i]);
        }
    }

    static void setToRight() {
        for(int i = 2; i<n; i++){
            max = Math.max(max, sum[n] - honey[n] - honey[i] + sum[i - 1]);
        }
    }

    static void setToMiddle() {
        for(int i = 2; i<n; i++){
            max = Math.max(max, sum[i] - honey[1] + sum[n] - sum[i - 1] - honey[n]);
        }
    }
}
