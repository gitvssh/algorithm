package algorithm.baek.numbertheory;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/4504
 * 배수 찾기

 */
public class FindingMultiple implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        while (true) {
            if (num % n == 0) {
                System.out.println(num + " is a multiple of "+n+".");
            } else {
                System.out.println(num + " is NOT a multiple of "+n+".");
            }
            num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
        }
    }
}
