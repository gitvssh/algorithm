package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class DiceGame implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int price = 0;
            if(n == m && m == l) {
                price = 10000 + n * 1000;
            }else if(n == m || m == l || n == l) {
                if(n==l) m = n;
                price = 1000 + m * 100;
            }else {
                price = Math.max(n, Math.max(m, l)) * 100;
            }
            max = Math.max(max, price);
        }
        bw.write(max + "");
        bw.flush();
        bw.close();
    }
}
