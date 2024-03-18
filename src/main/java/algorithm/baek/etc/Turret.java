package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class Turret implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int d = (int) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            int r = (int) (Math.pow(r1 + r2, 2));
            int r3 = (int) (Math.pow(r1 - r2, 2));
            if (x1 == x2 && y1 == y2 && r1 == r2) {
                bw.write("-1");
            } else if (d == r || d == r3) {
                bw.write("1");
            } else if (d > r || d < r3) {
                bw.write("0");
            } else {
                bw.write("2");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
