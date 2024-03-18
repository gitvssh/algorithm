package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1124
 * 언더프라임
 * 에라토스테네스의 체
 */
public class UnderPrime implements TestCase {
    static final int MAX = 100000;
    static boolean[] isPrime = new boolean[MAX + 1];
    static int[] cnt = new int[MAX + 1];

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        setPrime();
        for (int i = 2; i <= MAX; i++) {
            cnt[i] = countFactors(i);
        }
        int ans = 0;
        for (int i = a; i <= b; i++) {
            if (isUnderPrime(i)) ans++;
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

    public static int countFactors(int num) {
        int count = 0;
        int temp = num;
        for (int i = 2; i * i <= temp; i++) {
            while (num % i == 0) {
                count++;
                num /= i;
            }
        }
        if (num > 1) count++;
        return count;
    }

    public static boolean isUnderPrime(int i) {
        return isPrime[cnt[i]];
    }

    public static void setPrime() {
        for (int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= MAX; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j <= MAX; j += i) {
                isPrime[j] = false;
            }
        }
    }

}
