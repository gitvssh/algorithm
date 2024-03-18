package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.*;
import java.math.BigInteger;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/4134
 * 다음 소수
 */
public class NextPrime implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            BigInteger bigInteger = new BigInteger(String.valueOf(num));
            if (bigInteger.isProbablePrime(10)) {  // 입력 값이 소수면 그대로 출력
                System.out.println(bigInteger);
            } else {  // 입력 값이 소수가 아니면 다음 소수를 구해서 출력
                System.out.println(bigInteger.nextProbablePrime());
            }
        }
    }
}
