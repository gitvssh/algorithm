package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1735
 * 분수 합
 */
public class FractionSum implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int lcm = lcm(b1, b2);
        int a = a1 * (lcm / b1) + a2 * (lcm / b2);
        int b = lcm;
        int gcd = gcd(a, b);
        System.out.println(a / gcd + " " + b / gcd);
    }

    public static int gcd(int n, int m) {
        if (m == 0) return n;
        return gcd(m, n % m);
    }

    public static int lcm(int n, int m) {
        return n * m / gcd(n, m);
    }
}
