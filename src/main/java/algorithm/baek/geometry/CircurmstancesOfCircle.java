package algorithm.baek.geometry;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.StringTokenizer;

public class CircurmstancesOfCircle implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = null;
        String str = br.readLine();
        while (true) {
            st = new StringTokenizer(str);
            Point a = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
            Point b = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
            Point c = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));

            double d = 2 * (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y));
            double x =
                    ((a.x * a.x + a.y * a.y) * (b.y - c.y) + (b.x * b.x + b.y * b.y) * (c.y - a.y) + (c.x * c.x + c.y * c.y) * (a.y - b.y))
                            / d;
            double y =
                    ((a.x * a.x + a.y * a.y) * (c.x - b.x) + (b.x * b.x + b.y * b.y) * (a.x - c.x) + (c.x * c.x + c.y * c.y) * (b.x - a.x))
                            / d;

            // 원주를 구하고 소수점 2째자리 반올림
            double r = Math.sqrt((a.x - x) * (a.x - x) + (a.y - y) * (a.y - y));
            // 반지름 2째 자리 반올림
            System.out.printf("%.2f", 2*r*Math.PI);
            System.out.println();
            str = br.readLine();
            if (str == null || str.isEmpty()) {
                break;
            }
        }

    }

    public static class Point {

        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
