package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13172
 * Σ
 * 수학, 정수론, 분할 정복을 이용한 거듭제곱, 모듈로 곱셈 역원, 페르마의 소정리
 */
public class Sigma implements TestCase {
    static long Modulus = 1000000007;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long N = 1, S = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            S = s * N + S * n;
            N *= n;
            S %= Modulus;
            N %= Modulus;

        }
        if (S % N != 0)
            bw.write((pow(N, Modulus - 2) * S) % Modulus + "");
        else
            bw.write(S / N + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static long pow(long base, long exponent) {
        if (exponent == 1) {
            return base % Modulus;
        }

        long temp = pow(base, exponent / 2);

        if (exponent % 2 == 1) {
            return (temp * temp % Modulus) * base % Modulus;
        }
        return temp * temp % Modulus;
    }
}
