package algorithm.baek.simulation;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * https://www.acmicpc.net/problem/2931 백준 2931 가스관
 */
public class GasPipeSimulator implements TestCase {

    /*
    분석(5m)
    요구사항 도출(10m)
    설계(15m)

    1. 유럽이 R행 C열로 구성된 2차원 배열로 주어진다.
    2. 각 칸은 다음 중 하나이다.
        - '.' : 빈 칸
        - 'M' : 모스크바
        - 'Z' : 자그레브
        - '|' : 수직 가스관
        - '+' : 수직수평 방향 가스관
        - '-' : 수평 방향 가스관
        - '1' : 왼쪽 위 모서리 가스관
        - '2' : 왼쪽 아래 모서리 가스관
        - '3' : 오른쪽 아래 모서리 가스관
        - '4' : 오른쪽 위 모서리 가스관
     3. 항상 답이 존재하며, 가스의 흐름은 유일하다.

     가스관
     - 가스관은 enum 으로 정의한다.
     - 가스의 입력 방향에 대한 출력 방향이 존재한다.

     지도
      - 지도는 2차원 Character 배열로 정의한다.
      - 지도는 시작과 끝을 조회할 수 있다.
      - 지도는 가스 흐름에 문제가 있는 지점을 찾을 수 있다.
      - 지도는 가스 흐름에 문제가 있는 지점을 수정하여 가스 흐름 시뮬레이션을 실행할 수 있다.

      요구사항
      1. 지도를 생성할 수 있다.
      2. 지도는 가스 흐름에 문제가 있는 지점을 찾을 수 있다.
      3. 지도는 가스 흐름에 문제가 있는 지점을 수정하여 가스 흐름 시뮬레이션을 실행할 수 있다.

     */

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        EuropeanMap europeanMap = new EuropeanMap(R, C);
        ArrayList<String> mapData = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            mapData.add(br.readLine());
        }
        europeanMap.update(mapData);
        Position errorPoint = europeanMap.check();
        if (errorPoint != null) {
            for (GasPipe pipe : GasPipe.values()) {
                if (europeanMap.fixError(errorPoint, pipe)) {
                    break;
                }
            }
        }

        System.out.println(europeanMap.printResult());
    }

    public static class EuropeanMap {

        Character[][] map;
        Position start;
        Position end;
        Position error;

        GasPipe fixGasPipe;

        public EuropeanMap(int y, int x) {
            map = new Character[y][x];
        }

        public void update(ArrayList<String> mapData) {
            for (int y = 0; y < map.length; y++) {
                String row = mapData.get(y);
                map[y] = Arrays.stream(row.split(""))
                        .map(s -> s.charAt(0))
                        .toArray(Character[]::new);
            }
            IntStream.range(0, map.length)
                    .forEach(y -> {
                        IntStream.range(0, map[y].length)
                                .filter(x -> map[y][x] == 'M')
                                .findFirst()
                                .ifPresent(x -> start = new Position(x, y));

                        IntStream.range(0, map[y].length)
                                .filter(x -> map[y][x] == 'Z')
                                .findFirst()
                                .ifPresent(x -> end = new Position(x, y));
                    });
        }

        public Position getStart() {
            return start;
        }

        public Position getEnd() {
            return end;
        }

        public Position check() {
            //시작 포인트에서 방향 찾기
            Direction dir = findStartDirection();
            Position tmpStart = this.start;
            while (true) {
                int[] correlation = dir.getCorrelation();
                int nextX = tmpStart.getX() + correlation[1];
                int nextY = tmpStart.getY() + correlation[0];
                if (nextX < 0 || nextX >= map[0].length || nextY < 0 || nextY >= map.length) {
                    return error;
                }
                //도중에 파이프가 아닌 곳을 찾으면, 해당 포지션 반환
                if (map[nextY][nextX] == '.') {
                    if(error == null){
                        error = new Position(nextX, nextY);
                    }
                    return error;
                }
                //Z에 도달할 때까지 반복
                if (map[nextY][nextX] == 'Z') {
                    return null;
                }
                tmpStart = new Position(nextX, nextY);
                dir = GasPipe.getByValue(map[nextY][nextX]).getNextDirection(dir);
                if (dir == null) {
                    return error;
                }
            }
        }

        private Direction findStartDirection() {
            int startX = start.getX();
            int startY = start.getY();
            for (Direction dir : Direction.values()) {
                int[] correlation = dir.getCorrelation();
                int nextX = startX + correlation[1];
                int nextY = startY + correlation[0];
                if (nextX >= 0 && nextX < map[0].length && nextY >= 0 && nextY < map.length) {
                    if (map[nextY][nextX] != '.' && map[nextY][nextX] != 'Z') {
                        return dir;
                    }
                }
            }
            return null;
        }

        public Boolean fixError(Position errorPoint, GasPipe gasPipe) {
            char backup = map[errorPoint.getY()][errorPoint.getX()];
            map[errorPoint.getY()][errorPoint.getX()] = gasPipe.value;

            if (check() == null) {
                fixGasPipe = gasPipe;
                return true;
            }

            map[errorPoint.getY()][errorPoint.getX()] = backup;
            return false;
        }

        public String printResult() {
            return (error.getY() + 1) + " " + (error.getX() + 1) + " " + fixGasPipe.value;
        }
    }

    public enum Direction {
        NORTH(new int[]{-1, 0}), EAST(new int[]{0, 1}), SOUTH(new int[]{1, 0}), WEST(new int[]{0, -1});

        private final int[] correlation;

        Direction(int[] direction) {
            this.correlation = direction;
        }

        public int[] getCorrelation() {
            return correlation;
        }
    }

    public enum GasPipe {
        VERTICAL('|'),
        HORIZONTAL('-'),
        CROSS('+'),
        CORNER_TOP_LEFT('1'),
        CORNER_BOTTOM_LEFT('2'),
        CORNER_BOTTOM_RIGHT('3'),
        CORNER_TOP_RIGHT('4');

        final char value;

        GasPipe(char value) {
            this.value = value;
        }

        public static GasPipe getByValue(char value) {
            for (GasPipe gasPipe : GasPipe.values()) {
                if (gasPipe.value == value) {
                    return gasPipe;
                }
            }
            return null;
        }

        public Direction getNextDirection(Direction dir) {
            switch (this) {
                case VERTICAL:
                    if(dir == Direction.NORTH || dir == Direction.SOUTH) {
                        return dir;
                    }
                    return null;
                case CROSS:
                    return dir;
                case HORIZONTAL:
                    if(dir == Direction.EAST || dir == Direction.WEST) {
                        return dir;
                    }
                    return null;
                case CORNER_TOP_LEFT:
                    if (dir == Direction.NORTH) {
                        return Direction.EAST;

                    } else if (dir == Direction.WEST) {
                        return Direction.SOUTH;
                    }
                    return null;
                case CORNER_BOTTOM_LEFT:
                    if (dir == Direction.SOUTH) {
                        return Direction.EAST;

                    } else if (dir == Direction.WEST) {
                        return Direction.NORTH;
                    }
                    return null;
                case CORNER_BOTTOM_RIGHT:
                    if (dir == Direction.SOUTH) {
                        return Direction.WEST;

                    } else if (dir == Direction.EAST) {
                        return Direction.NORTH;
                    }
                    return null;
                case CORNER_TOP_RIGHT:
                    if (dir == Direction.NORTH) {
                        return Direction.WEST;

                    } else if (dir == Direction.EAST) {
                        return Direction.SOUTH;
                    }
                    return null;
            }
            return null;
        }
    }

    public static class Position {

        private final int x;
        private final int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }
}
