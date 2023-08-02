package algorithm.baek.greedy;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1817
 * 짐 챙기는 숌
 * 그리디
 */
public class PackingShom implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if (sum > m) {
                cnt++;
                sum = arr[i];
            }
        }
        if (sum > 0) {
            cnt++;
        }
        System.out.println(cnt);
    }
}
