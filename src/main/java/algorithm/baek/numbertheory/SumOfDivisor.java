package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/2501
 * 약수들의 합
 */
public class SumOfDivisor implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
        int n = 0;
        while ((n = Integer.parseInt(br.readLine())) != -1) {
            int sum = 0;
            sb = new StringBuilder();
            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0) {
                    sum += i;
                    sb.append(i).append(" + ");
                }
            }
            if (sum == n) {
                sb.delete(sb.length() - 3, sb.length());
                bw.write(n + " = " + sb.toString());
            } else {
                bw.write(n + " is NOT perfect.");
            }
            bw.newLine();
        }
        bw.close();
    }
}
