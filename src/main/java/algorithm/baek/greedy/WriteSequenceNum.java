package algorithm.baek.greedy;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/1515
 * 수 이어 쓰기
 */
public class WriteSequenceNum implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int pt = 0;
        int base = 0;
        while (base++ <= 30000) {
            String tmp = String.valueOf(base);
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == s.charAt(pt))
                    pt++;
                if (pt == s.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }
    }
}
