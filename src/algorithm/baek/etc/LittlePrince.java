package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class LittlePrince implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int x3 = Integer.parseInt(st.nextToken());
                int y3 = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                if (isInCircle(x1, y1, x3, y3, r) != isInCircle(x2, y2, x3, y3, r)) {
                    cnt++;
                }
            }
            bw.write(cnt + "");
            bw.newLine();
        }
        bw.close();
    }

    private boolean isInCircle(int x1, int y1, int x3, int y3, int r) {
        return Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2) < Math.pow(r, 2);
    }
}
