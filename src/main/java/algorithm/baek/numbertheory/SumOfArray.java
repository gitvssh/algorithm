package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1024
 * 수열의 합
 * 수학
 */
public class SumOfArray implements TestCase {
    @Override
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long N = Long.parseLong(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        boolean isFound = false;

        while(L <= 100){
            long start = N / L - (L - 1) / 2;
            if (start < 0) {
                break;
            }

            long sum = 0;
            for (int i = 0; i < L; i++) {
                sum += start + i;
            }

            if (sum == N) {
                for (int i = 0; i < L; i++) {
                    bw.write(String.valueOf(start + i) + " ");
                }
                isFound = true;
                break;
            }
            L++;
        }

        if (!isFound) {
            bw.write(String.valueOf(-1));
        }
        bw.close();
    }
}
