package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/2444
 * 별 찍기 - 7
 */
public class Star7 implements TestCase {
    static BufferedReader br;
    static BufferedWriter bw;

    @Override
    public void test() throws ParseException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 2 * n - 1; i++) {
            if (i < n) { // upper
                for (int j = 1; j < n; j++) {
                    if (j < n - i) bw.write(" ");
                    else
                        bw.write("*");
                }
                for (int j = 0; j <= n; j++) {
                    if (j <= i) bw.write("*");
                }
            } else { // lower
                for (int j = 1; j < n; j++) {
                    if (j <= i - n + 1) bw.write(" ");
                    else
                        bw.write("*");
                }
                for (int j = 0; j < 2 * n - i - 1; j++) {
                    bw.write("*");
                }
            }
            bw.newLine();
        }
        bw.close();
    }
}
