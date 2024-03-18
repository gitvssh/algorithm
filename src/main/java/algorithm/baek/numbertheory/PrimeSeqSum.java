package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/1644
 * 소수의 연속합
 * 투포인터
 */
public class PrimeSeqSum implements TestCase {

    static boolean[] prime;
    static int primeSize;
    static int[] primeArr;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        init(n);
        int start = 0, end = 0;
        int result = 0;
        while (start <= end) {
            if(end == primeSize) break;
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += primeArr[i];
            }
            if (sum == n) {
                result++;
                end++;
            } else if (sum < n) {
                end++;
            } else {
                start++;
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }

    public static void init(int n) {
        primeSize = 0;
        prime = new boolean[n + 1];
        prime[1] = true;
        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!prime[i]) {
                primeSize++;
            }
        }
        primeArr = new int[primeSize+1];
        int index = 0;
        for (int i = 2; i <= n; i++) {
            if (!prime[i]) {
                primeArr[index++] = i;
            }
        }
    }


}
