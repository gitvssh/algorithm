package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

public class Zero implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int idx = 0;
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            if (m != 0) {
                arr[idx++] = m;
            } else {
                arr[--idx] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        bw.write(sum + "\n");
        bw.close();
    }
}
