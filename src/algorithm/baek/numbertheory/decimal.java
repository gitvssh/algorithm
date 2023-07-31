package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1312
 * 소수
 * 수학
 */
public class decimal implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();

        int result = a % b;

        for(int i=0; i<n-1; i++){
            result *= 10;
            result %= b;
        }

        result *= 10;

        System.out.println(result/b);
    }
}
