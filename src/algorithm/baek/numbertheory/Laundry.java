package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/2720
 * 세탁소 사장 동혁
 */
public class Laundry implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int c = Integer.parseInt(br.readLine());
            int q = c / 25;
            c %= 25;
            int d = c / 10;
            c %= 10;
            int n = c / 5;
            c %= 5;
            bw.write(q + " " + d + " " + n + " " + c);
            bw.newLine();
        }
        bw.close();
    }
}
