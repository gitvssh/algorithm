package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2501
 * 약수 구하기
 */
public class CountDivisor implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int result = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) cnt++;
            if (cnt == k) {
                System.out.println(i);
                return;
            }
        }
        if (cnt == k - 1) System.out.println(n);
        else System.out.println(0);
    }
}
