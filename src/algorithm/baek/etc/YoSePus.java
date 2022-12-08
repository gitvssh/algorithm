package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class YoSePus implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        boolean flag = true;
        int idx = 0;
        int total = 0;
        bw.write("<");
        while (flag) {
            int cnt = 0;

            while (cnt != k) {
                if (arr[idx] != 0) {
                    cnt++;
                }
                if (cnt == k) {
                    bw.write(arr[idx]);
                    arr[idx - 1] = 0;
                    total++;
                }
                idx = (idx+1) % n;
            }
            if (total == n - 1) {
                bw.write(arr[idx] + ">");
                flag = false;
            } else {
                bw.write(arr[idx] + ", ");
            }
        }
        bw.close();
    }
}