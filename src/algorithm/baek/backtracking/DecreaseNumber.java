package algorithm.baek.backtracking;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/1038
 * 감소하는 수
 * 백트래킹
 */
public class DecreaseNumber implements TestCase {
    static List<Long> list = new ArrayList<>();
    static int N;
    static int count = 0;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        if (N <= 10) {
            System.out.print(N);
            return;
        } else if (N >= 1023) {
            System.out.print(-1);
            return;
        }

        for (int i = 0; i < 10; i++) {
            DFS(i);
        }

        Collections.sort(list);
        System.out.print(list.get(N));
    }

    private static void DFS(long num) {
        list.add(num);
        long modValue = num % 10;
        if (modValue == 0) {
            return;
        }

        for (long i = modValue - 1; i >= 0; i--) {
            long newValue = num * 10 + i;
            DFS(newValue);
        }
    }
}
