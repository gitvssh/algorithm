package algorithm.baek.cumulativesum;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/2851
 * 슈퍼 마리오
 * 누적합
 */
public class SuperMario implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[10];
        int[] sum = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum[i] = (i == 0 ? 0 : sum[i - 1]) + arr[i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            if (Math.abs(100 - sum[i]) < Math.abs(100 - min)) {
                min = sum[i];
            } else if (Math.abs(100 - sum[i]) == Math.abs(100 - min)) {
                min = Math.max(min, sum[i]);
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}
