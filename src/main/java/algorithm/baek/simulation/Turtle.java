package algorithm.baek.simulation;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/8911 거북이
 */
public class Turtle implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            TurtleRobot robot = new TurtleRobot();
            for (int j = 0; j < s.length(); j++) {
                robot.move(s.charAt(j));
            }
            System.out.println(robot.getArea());
        }
    }

    static class TurtleRobot {

        Position pos;
        Direction dir;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int minX;
        int maxX;
        int minY;
        int maxY;

        public TurtleRobot() {
            this.pos = new Position(0, 0, Direction.NORTH);
            this.pos.x = 0;
            this.pos.y = 0;
            dir = Direction.NORTH;
            minX = 0;
            maxX = 0;
            minY = 0;
            maxY = 0;
        }

        public void move(char c) {
            if (c == 'F') {
                this.pos.x += dx[dir.value];
                this.pos.y += dy[dir.value];
            } else if (c == 'B') {
                this.pos.x -= dx[dir.value];
                this.pos.y -= dy[dir.value];
            } else if (c == 'L') {
                dir = Direction.values()[(dir.value + 3) % 4];
            } else if (c == 'R') {
                dir = Direction.values()[(dir.value + 1) % 4];
            }
            minX = Math.min(minX, this.pos.x);
            maxX = Math.max(maxX, this.pos.x);
            minY = Math.min(minY, this.pos.y);
            maxY = Math.max(maxY, this.pos.y);

        }

        public int getArea() {
            return (maxX - minX) * (maxY - minY);
        }

        public Direction getDirection() {
            return this.dir;
        }

        public Position getPosition() {
            return this.pos;
        }
    }

    enum Direction {
        NORTH(0), EAST(1), SOUTH(2), WEST(3);
        final int value;
        Direction(int value) {
            this.value = value;
        }
    }

    static class Position {
        int x;
        int y;
        Direction dir;
        public Position(int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
