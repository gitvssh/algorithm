package algorithm.baek.twopointer;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2467
 * 용액
 * 투 포인터
 */
public class Liquid implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n - 1;
        int min = Integer.MAX_VALUE;
        int[] result = new int[2];
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                result[0] = arr[left];
                result[1] = arr[right];
            }
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        bw.write(result[0] + " " + result[1] + "\n");
        bw.flush();
        bw.close();
    }
}
