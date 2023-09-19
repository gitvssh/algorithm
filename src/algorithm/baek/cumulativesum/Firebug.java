package algorithm.baek.cumulativesum;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3020
 * 개똥벌레
 * 누적합
 */
public class Firebug implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer((br.readLine()));
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] up = new int[h + 1];
        int[] down = new int[h + 1];
        for (int i = 0; i < n / 2; i++) {
            down[Integer.parseInt(br.readLine())]++;
            up[Integer.parseInt(br.readLine())]++;
        }
        for (int i = h - 1; i > 0; i--) {
            down[i] += down[i + 1];
            up[i] += up[i + 1];
        }
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= h; i++) {
            int sum = down[i] + up[h - i + 1];
            if (sum < min) {
                min = sum;
                cnt = 1;
            } else if (sum == min) {
                cnt++;
            }
        }
        bw.write(String.valueOf(min) + " " + String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
