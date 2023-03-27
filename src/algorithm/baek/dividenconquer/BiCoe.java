package algorithm.baek.dividenconquer;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11401
 * 이항계수 3
 */
public class BiCoe implements TestCase {

    static final long p = 1000000007;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long numer = factorial(n);
        long denom = factorial(k) * factorial(n - k) % p;
        System.out.println(numer * pow(denom, p - 2) % p);
    }

    public static long factorial(long n) {
        long fac = 1L;
        while (n > 1) {
            fac = (fac * n) % p;
            n--;
        }
        return fac;
    }

    public static long pow(long base, long exponent) {
        if (exponent == 1) {
            return base % p;
        }

        long temp = pow(base, exponent / 2);

        if (exponent % 2 == 1) {
            return (temp * temp % p) * base % p;
        }
        return temp * temp % p;
    }
}
