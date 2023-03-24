package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14215
 * 세 막대
 */
public class ThreeSticks implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        if (a + b > c) {
            System.out.println(a + b + c);
        } else {
            System.out.println((a + b) * 2 - 1);
        }
    }
}
