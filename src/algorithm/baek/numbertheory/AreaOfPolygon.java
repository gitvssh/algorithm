package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class AreaOfPolygon implements TestCase {
    static double[][] arr;
    static int n;
    static double result;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        arr = new double[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i][0] = x;
            arr[i][1] = y;
        }

        for (int i = 0; i < n; i++) {
            double x1 = arr[i][0];
            double y1 = arr[i][1];
            double x2 = arr[(i + 1) % n][0];
            double y2 = arr[(i + 1) % n][1];

            result += x1 * y2;
            result -= x2 * y1;
        }

        result = Math.abs(result);
        result /= 2;

        double rounded = Math.round(result * 10.0) / 10.0;
        result = rounded;

        bw.write(String.format("%.1f", result));
        bw.close();
    }
}
