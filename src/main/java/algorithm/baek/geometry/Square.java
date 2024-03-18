package algorithm.baek.geometry;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1485
 * 정사각형
 * 기하
 */
public class Square implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            Point[] points = new Point[4];
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                points[j] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            bw.write(isSquare(points) ? "1\n" : "0\n");
        }
        bw.flush();
        bw.close();
    }

    private boolean isSquare(Point[] points) {
        double[] dist = new double[6];
        dist[0] = getDist(points[0], points[1]);
        dist[1] = getDist(points[0], points[2]);
        dist[2] = getDist(points[0], points[3]);
        dist[3] = getDist(points[1], points[2]);
        dist[4] = getDist(points[1], points[3]);
        dist[5] = getDist(points[2], points[3]);
        Arrays.sort(dist);
        for (int i = 0; i < 3; i++) {
            if (dist[i] != dist[i + 1]) return false;
        }
        return dist[4] == dist[5];
    }

    private double getDist(Point point1, Point point2) {
        int dx = point1.x - point2.x;
        int dy = point1.y - point2.y;
        return Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
