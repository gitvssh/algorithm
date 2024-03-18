package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2745
 * 진법 변환
 */
public class BaseConversion implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i = n.length() - 1; i >= 0; i--) {
            char c = n.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                result += (c - 'A' + 10) * Math.pow(b, n.length() - 1 - i);
            } else {
                result += (c - '0') * Math.pow(b, n.length() - 1 - i);
            }
        }
        System.out.println(result);
    }
}
