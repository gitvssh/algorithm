package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

public class CuttingTree implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long target = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        long max = Long.MIN_VALUE;
        long min = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            max = Math.max(arr[i], max);
        }
        long res = 0;
        while (min < max) {
            long mid = (max + min) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    sum += arr[i] - mid;
                }
            }
            if (sum < target) {
                max = mid;
            } else {
                min = mid + 1;
            }
            res = min;
        }
        System.out.println("res = " + res);
    }
}
