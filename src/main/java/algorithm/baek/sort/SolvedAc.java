package algorithm.baek.sort;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/18110
 * solved.ac
 * 정렬
 */
public class SolvedAc implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cut = (int) Math.round(n * 0.15);

        Arrays.sort(arr);
        int sum = 0;
        for (int i = cut; i < n - cut; i++) {
            sum += arr[i];
        }
        int avg = (int) Math.round((double) sum / (n - cut * 2));
        bw.write(avg + "\n");
        bw.flush();
        bw.close();
    }
}
