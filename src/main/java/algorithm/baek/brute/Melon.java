package algorithm.baek.brute;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class Melon implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Coordinate cur = new Coordinate();
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Coordinate c1 = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), cur);
        }
    }

    private class Coordinate {
        int x;
        int y;

        public Coordinate() {
            this(0, 0);
        }

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coordinate(int x, int y, Coordinate cur) {
            int[] adjX = {0, 1, -1, 0, 0};
            int[] adjY = {0, 0, 0, -1, 1};
            this.x = cur.getX() + adjX[x] * x;
            this.y = cur.getY() + adjY[x] * y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
