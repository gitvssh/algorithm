package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1063
 * King
 */
public class King implements TestCase {
    static Pos king, stone;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        king = new Pos(s.charAt(0) - 'A', s.charAt(1) - '1');
        String s2 = st.nextToken();
        stone = new Pos(s2.charAt(0) - 'A', s2.charAt(1) - '1');
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            Direction dir = Direction.valueOf(br.readLine());

            //이동경로가 돌과 겹치지 않는 경우
            if (king.canMove(dir) && !king.move(dir).isSame(stone)) king = king.move(dir);
                //이동경로가 돌과 겹치는경우
            else if (king.canMove(dir) && king.move(dir).isSame(stone)) {
                //돌이 이동할 수 있는 경우
                if (stone.canMove(dir)) {
                    king = king.move(dir);
                    stone = stone.move(dir);
                }
            }

        }
        bw.write(king.getPos() + "\n");
        bw.write(stone.getPos() + "\n");
        bw.flush();
        bw.close();
    }

    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Pos move(Direction dir) {
            return new Pos(x + dir.x, y + dir.y);
        }

        boolean canMove(Direction dir) {
            Pos next = move(dir);
            return next.x >= 0 && next.x < 8 && next.y >= 0 && next.y < 8;
        }

        boolean isSame(Pos pos) {
            return x == pos.x && y == pos.y;
        }

        String getPos() {
            return (char) (x + 'A') + "" + (char) (y + '1');
        }
    }

    enum Direction {
        R(1, 0), L(-1, 0), B(0, -1), T(0, 1), RT(1, 1), LT(-1, 1), RB(1, -1), LB(-1, -1);
        int x, y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
