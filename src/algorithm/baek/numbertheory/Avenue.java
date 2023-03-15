package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/2485
 * 가로수
 */
public class Avenue implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int gcd = arr[1] - arr[0];
        for (int i = 2; i < n; i++) {
            gcd = gcd(gcd, arr[i] - arr[i - 1]);
        }

        int count = 0;
        for (int i = 1; i < n; i++) {
            count += (arr[i] - arr[i - 1]) / gcd - 1;
        }

        System.out.println(count);

    }

    public static int gcd(int n, int m) {
        if (m == 0) return n;
        return gcd(m, n % m);
    }
}
