package algorithm.baek.simulation;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/14499
 * 백준 14499 주사위 굴리기
 */
public class RollingDice implements TestCase {

    /*
    1. 지도가 주어지고 주사위의 위치가 주어진다.
    2. 주사위는 6면체이고 각 면에는 처음엔 0이 적혀있다.
    3. 주사위는 명령에 따라 움직이며 특정 규칙에 따라 지도에 숫자를 쓰거나 주사위 면에 숫자를 쓴다.
    4. 주사위는 지도의 바깥으로 이동하려고 하는 경우 명령을 무시한다.
    5. 매 이동 시 상단에 쓰여있는 값을 출력한다.

    지도:
    - N x M 크기의 지도
    - 각 칸에는 정수가 하나씩 쓰여있음
    - 정수는 변경될 수 있다.
    주사위:
    - 명령에 따라 움직일 수 있어야 함
    - 특정 규칙에 따라 지도에 숫자를 쓰거나 주사위 면에 숫자를 쓸 수 있어야 함
    - 지도 밖으로 움직이는 경우 명령을 무시해야 함
    - 주사위가 움직일 때, 각 면의 숫자가 어떻게 변하는지를 구현해야 함

    요구사항:
    - 주사위는 명령에 따라 움직일 수 있다.
    - 주사위는 지도 밖으로 이동하지 않는다.
    - 지도는 특정 상황에서 값이 변경된다.
    - 주사위는 특정 규칙에 따라 값이 변경된다.
    - 주사위는 현재 상단의 값을 출력할 수 있다.
     */

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    @Override
    public void test() throws ParseException, IOException {
        String[] split = br.readLine().split(" ");
        int y = Integer.parseInt(split[0]);
        int x = Integer.parseInt(split[1]);
        int yPosition = Integer.parseInt(split[2]);
        int xPosition = Integer.parseInt(split[3]);
        Dice dice = new Dice(xPosition, yPosition);
        Map map = new Map(y, x, dice);
        map.map = new int[y][x];
        for (int i = 0; i < y; i++) {
            String[] split1 = br.readLine().split(" ");
            for (int j = 0; j < x; j++) {
                map.map[i][j] = Integer.parseInt(split1[j]);
            }
        }
        String[] commands = br.readLine().split(" ");
        for (String command : commands) {
            int lowDir = Integer.parseInt(command);
            if(map.moveDice(lowDir)){
                bw.write(map.getDice().dice[0] + "\n");
            }
        }
        bw.flush();
    }

    public static class Dice {

        Point point;

        int[] dice;

        public Dice(int x, int y) {
            this.point = new Point(x, y);
            this.dice = new int[]{0, 0, 0, 0, 0, 0};
        }

        public Point getPoint() {
            return point;
        }

        public boolean move(int lowDir, Map map) {
            Direction dir = Direction.getByValue(lowDir);
            Point nextPoint = switch(dir) {
                case EAST -> new Point(point.x + 1, point.y);
                case WEST -> new Point(point.x - 1, point.y);
                case SOUTH -> new Point(point.x, point.y - 1);
                case NORTH -> new Point(point.x, point.y + 1);
            };
            if(isOutOfMap(nextPoint, map)) return false;
            rollingDice(dir);
            point = nextPoint;
            if(map.getValue(point) == 0){
                map.setValue(point, dice[5]);
            } else {
                dice[5] = map.getValue(point);
                map.setValue(point, 0);
            }
            return true;
        }

        private void rollingDice(Direction dir) {
            int[] temp = dice.clone();
            switch (dir) {
                case EAST -> { // 0 2 3 5 / 0->3, 2->0, 3->5, 5->2
                    dice[0] = temp[3];
                    dice[2] = temp[0];
                    dice[3] = temp[5];
                    dice[5] = temp[2];
                }
                case WEST -> { // 0 2 3 5 / 0->2, 2->5, 3->0, 5->3
                    dice[0] = temp[2];
                    dice[2] = temp[5];
                    dice[3] = temp[0];
                    dice[5] = temp[3];
                }
                case SOUTH -> { // 1 0 4 5 / 1->4, 0->5, 4->0, 5->1
                    dice[0] = temp[4];
                    dice[1] = temp[0];
                    dice[4] = temp[5];
                    dice[5] = temp[1];
                }
                case NORTH -> { // 1 0 4 5 / 1->0, 0->4, 4->5, 5->1
                    dice[0] = temp[1];
                    dice[1] = temp[5];
                    dice[4] = temp[0];
                    dice[5] = temp[4];
                }
            }
        }

        private boolean isOutOfMap(Point toPosition, Map map) {
            return toPosition.x < 0 || toPosition.x >= map.getxLength() ||
                    toPosition.y < 0 || toPosition.y >= map.getyLength();
        }
    }

    public enum Direction {

        EAST(1),
        WEST(2),
        SOUTH(3),
        NORTH(4);

        private final int value;

        Direction(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Direction getByValue(int value){
            for (Direction direction : values()){
                if(direction.value == value){
                    return direction;
                }
            }
            return null;
        }
    }

    public static class Map {

        private final int xLength;
        private final int yLength;
        private Dice dice;
        int[][] map;

        public Map(int y, int x, Dice dice) {
            this.xLength = x;
            this.yLength = y;
            this.dice = dice;
            this.map = new int[y][x];
        }

        public boolean moveDice(int lowDir) {
            return dice.move(lowDir, this);
        }

        public Dice getDice() {
            return this.dice;
        }

        public int getxLength() {
            return this.xLength;
        }

        public int getyLength() {
            return this.yLength;
        }

        public int getValue(Point point) {
            return map[point.y][point.x];
        }

        public void setValue(Point point, int i) {
            map[point.y][point.x] = i;
        }
    }

    public static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                Point point = (Point) obj;
                return this.x == point.x && this.y == point.y;
            } else if (obj instanceof String) {
                String[] split = ((String) obj).split(" ");
                return this.x == Integer.parseInt(split[0]) && this.y == Integer.parseInt(split[1]);
            }
            return super.equals(obj);
        }

    }
}
