package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class KaingCalendar implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= 1600000000; j++) {
                if (j % m == x && j % n == y) {
                    bw.write(j + "");
                    bw.newLine();
                    break;
                }
                if (j == 1600000000) {
                    bw.write("-1");
                    bw.newLine();
                }
            }
        }
        bw.close();
    }
}
