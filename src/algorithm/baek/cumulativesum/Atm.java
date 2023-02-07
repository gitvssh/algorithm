package algorithm.baek.cumulativesum;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11399
 * ATM
 */
public class Atm implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[tc];
        int[] sum = new int[tc];
        for (int i = 0; i < tc; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        sum[0] = arr[0];
        int result = sum[0];
        for (int i = 1; i < tc; i++) {
            sum[i] = sum[i - 1] + arr[i];
            result += sum[i];
        }
        bw.write(result + "\n");
        bw.close();
    }
}
