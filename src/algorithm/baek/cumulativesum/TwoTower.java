package algorithm.baek.cumulativesum;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/2118
 * 두 개의 탑
 * 누적합
 */
public class TwoTower implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int boards[] = new int[N + 1];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            boards[i] = n;
            sum += n;
        }

        int start = 0;
        int last = 0;
        int result = 0;
        int now = boards[start];
        while (start <= last && last < N) {
            int minNow = Integer.min(now, sum - now);
            result = Integer.max(result, minNow);
            if (now == minNow) {
                last++;
                now += boards[last];
            } else {
                now -= boards[start];
                start++;
            }
        }
        System.out.println(result);
    }
}
