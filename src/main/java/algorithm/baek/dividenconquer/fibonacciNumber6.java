package algorithm.baek.dividenconquer;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/11444
 * 피보나치 수 6
 * 수학, 분할 정복을 이용한 행렬 제곱
 */
public class fibonacciNumber6 implements TestCase {
    static long[][] base = {{1, 1}, {1, 0}};
    static long[][] start = {{1, 1}, {1, 0}};
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long[][] result = pow(base, n-1);

        System.out.print(result[0][0]);
    }

    public long[][] pow(long[][] A, long exponent) {
        if (exponent == 1 || exponent == 0) {
            return A;
        }
        long[][] temp = pow(A, exponent / 2);
        long[][] result = multiply(temp, temp);
        if (exponent % 2 == 1) {
            result = multiply(result, base);
        }
        return result;
    }

    public long[][] multiply(long[][] a, long[][] b) {
        long[][] result = new long[2][2];
        result[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % 1000000007;
        result[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % 1000000007;
        result[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % 1000000007;
        result[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % 1000000007;
        return result;
    }
}
