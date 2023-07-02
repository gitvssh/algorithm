package algorithm.baek.brute;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20529
 * 가장 가까운 세사람
 */
public class ThreeClosestPeople implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int[] count = new int[5];
            int n = Integer.parseInt(br.readLine());
            if(n>32){
                bw.write("0\n");
                st = new StringTokenizer(br.readLine());
                continue;
            }
            String[] arr = new String[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = st.nextToken();
            }
            int result = Integer.MAX_VALUE;

            for (int j = 0; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int l = k + 1; l < n; l++) {
                        int diff = diff(arr[j], arr[k]) + diff(arr[j], arr[l]) + diff(arr[k], arr[l]);
                        if (diff < result) {
                            result = diff;
                        }
                    }
                }
            }

            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }

    public int diff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }
}
