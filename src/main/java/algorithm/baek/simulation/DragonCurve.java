package algorithm.baek.simulation;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * https://www.acmicpc.net/problem/15685
 * 백준 15685 드래곤 커브

 */
public class DragonCurve implements TestCase {

    /*
    드래곤커브 구성요소
    1. 시작점
    2. 시작 방향
    3. 세대

    한 세대는 이전 세대의 끝점을 기준으로 90도 회전한 방향으로 그려진다.
    0세대 드래곤커브는 길이가 1인 선분이다.
    시작점, 끝점으로 이루어진 선분이 매 세대마다 2배로 증가한다.

    2h 예상
    분석(5m -> 10m)
    설계(15m -> 10m)
    구현+테스트(1h+)
    Direction(5m)

    드래곤커브:
    - List<Line> lines
    - int Generation
    - 회전가능
    - 정사각형의 개수 반환 가능
    - 끝점을 방향으로 확인

    Line:
    - Point start
    - Point end

    Point:
    - int x
    - int y

    Map:
    - boolean[][] map
    - int countSquare()

    1. 드래곤커브는 끝점을 기준으로 회전할 수 있다.
    2. 드래곤커브는 여러 세대로 진화할 수 있다.
    3. 드래곤커브는 지도에 그려질 수 있다.
    4. 여러개의 드래곤 커브를 지도에 그릴 수 있다.
    5. 지도는 정사각형의 개수를 반환할 수 있다.
     */

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void test() throws ParseException, IOException {
        int n = Integer.parseInt(br.readLine());
        Map map = new Map();
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            int dir = Integer.parseInt(split[2]);
            int generation = Integer.parseInt(split[3]);
            DragonCurveUnit dragonCurveUnit = new DragonCurveUnit(x, y, dir, generation);
            map.print(dragonCurveUnit);
        }
        System.out.println(map.getSquare());
    }

    public enum Direction {
        NORTH(1, new int[]{-1, 0}), EAST(0, new int[]{0, 1}),
        SOUTH(3, new int[]{1, 0}), WEST(2, new int[]{-1, 0});

        private final int value;
        private final int[] correction;


        Direction(int value, int[] correction) {
            this.value = value;
            this.correction = correction;
        }

        public int getValue() {
            return value;
        }

        public static Direction getByValue(int value) {
            for (Direction direction : Direction.values()) {
                if (direction.value == value) {
                    return direction;
                }
            }
            return null;
        }

        public Point getNextPoint(Point point){
            return new Point(point.getX() + this.correction[1], point.getY() + this.correction[0]);
        }
    }

    public static class DragonCurveUnit {

        private ArrayList<Line> lines;
        private Point axis;
        private int generation;

        public DragonCurveUnit(int x, int y, int dir) {
            this.lines = new ArrayList<>();
            Point start = new Point(x, y);
            Direction byValue = Direction.getByValue(dir);
            if(byValue == null){
                throw new IllegalArgumentException("Invalid Direction");
            }

            axis = byValue.getNextPoint(start);
            this.lines.add(new Line(start, axis));
            this.generation = 0;
        }

        DragonCurveUnit(int x, int y, int dir, int generation) {
            this(x, y, dir);
            for (int i = 0; i < generation; i++) {
                lotate();
            }
        }

        public int getGeneration() {
            return generation;
        }

        public ArrayList<Line> getLines() {
            return lines;
        }

        public void lotate() {
            ArrayList<Line> tmp = new ArrayList<>();
            boolean isFirst = true;
            Point tmpAxis = null;
            for (Line line : lines) {
                // 회전을 위한 기준점 이동
                Point start = new Point(line.getStart().getX() - axis.getX(), line.getStart().getY() - axis.getY());
                Point end = new Point(line.getEnd().getX() - axis.getX(), line.getEnd().getY() - axis.getY());
                // 회전 (x, y) -> (y, -x)
                Point rotateStart = new Point(-start.getY(), start.getX());
                Point rotateEnd = new Point(-end.getY(), end.getX());

                // 회전된 좌표를 원래 위치로 이동
                Point newStart = new Point(rotateStart.getX() + axis.getX(), rotateStart.getY() + axis.getY());
                Point newEnd = new Point(rotateEnd.getX() + axis.getX(), rotateEnd.getY() + axis.getY());
                tmp.add(new Line(newStart, newEnd));
                if(isFirst){
                    tmpAxis = newStart;
                    isFirst = false;
                }
            }
            axis = tmpAxis;
            // 회전된 선분을 추가
            for (Line line : tmp) {
                lines.add(line);
            }
            this.generation++;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof DragonCurveUnit){
                DragonCurveUnit other = (DragonCurveUnit) obj;
                return this.lines.equals(other.lines) && this.axis.equals(other.axis) && this.generation == other.generation;
            }
            return super.equals(obj);
        }
    }

    public static class Line {

        private Point start;
        private Point end;

        public Line(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

        public Point getStart() {
            return start;
        }

        public Point getEnd() {
            return end;
        }

    }

    public static class Map {

        private boolean map[][];
        private ArrayList<Line> lines;

        Map() {
            map = new boolean[101][101];
            lines = new ArrayList<>();
        }

        public void print(DragonCurveUnit dragonCurveUnit) {
            for (Line line : dragonCurveUnit.getLines()) {
                Point start = line.getStart();
                Point end = line.getEnd();

                map[start.getY()][start.getX()] = true;
                map[end.getY()][end.getX()] = true;

                lines.add(line);
            }
        }

        public boolean getPoint(int x, int y) {
            return map[y][x];
        }

        public int getSquare() {
            int count = 0;
            for (int i = 0; i <= 100; i++) {
                for (int j = 0; j <= 100; j++) {
                    if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public static class Point {

        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY(){
            return y;
        }
    }
}
