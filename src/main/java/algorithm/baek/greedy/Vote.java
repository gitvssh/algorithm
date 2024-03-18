package algorithm.baek.greedy;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1417
 * 국회의원 선거
 */
public class Vote implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int a = Integer.parseInt(br.readLine());
        int[] arr = new int[n - 1];
        for (int i = 0; i < n - 1; i++) arr[i] = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (true) {
            Arrays.sort(arr);
            if (arr[n - 2] < a) break;
            cnt++;
            arr[n - 2]--;
            a++;
        }
        System.out.println(cnt);
    }
}
