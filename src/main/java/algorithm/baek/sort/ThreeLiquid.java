package algorithm.baek.sort;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2473
 * 세 용액
 * 이분 탐색
 * 투 포인터
 */
public class ThreeLiquid implements TestCase {
    static int N;
    static long[] liquid;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        liquid = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            liquid[idx++] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(liquid);

        long min = Long.MAX_VALUE;

        int[] result = new int[3];

        for (int i = 0; i < N; i++) {
            long partialSum = liquid[i];
            int left = i + 1;
            int right = N - 1;
            while (left < right) {
                long sum = partialSum + liquid[left] + liquid[right];
                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    result[0] = i;
                    result[1] = left;
                    result[2] = right;
                }
                if (sum == 0) {
                    bw.write(liquid[result[0]] + " ");
                    bw.write(liquid[result[1]] + " ");
                    bw.write(liquid[result[2]] + " ");
                    bw.close();
                    return;
                }
                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        for (int j = 0; j < 3; j++) {
            bw.write(liquid[result[j]] + " ");
        }

        bw.close();
    }
}
