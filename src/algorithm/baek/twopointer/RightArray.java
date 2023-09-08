package algorithm.baek.twopointer;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1337
 * 올바른 배열
 * 투포인터
 */
public class RightArray implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt((br.readLine()));
        }
        Arrays.sort(arr);
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        while (start < n) {
            if (end < n && arr[end] - arr[start] < 5) {
                end++;
            } else {
                min = Math.min(min, 5 - (end - start));
                start++;
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}
