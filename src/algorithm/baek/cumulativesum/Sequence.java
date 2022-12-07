package algorithm.baek.cumulativesum;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class Sequence implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] base = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            base[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[n - m + 1];
        for (int i = 0; i < m; i++) {
            arr[0] += base[i];
        }
        int max = arr[0];
        for (int i = 1; i < n - m + 1; i++) {
            arr[i] = arr[i - 1] - base[i - 1] + base[i + m - 1];
            max = Math.max(max, arr[i]);
        }
        bw.write(max + "\n");
        bw.close();
    }
}
