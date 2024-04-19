package algorithm.baek.simulation;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2174 로봇 시뮬레이션
 */
public class RobotSimulation implements TestCase {

    /*
    객체 :
    땅 : 크기 1~100
    로봇 : 수 1~100
    방향 : N, E, S, W
    좌표 : (1,1) ~ (A,B)
    방향을 가지고 있음
    왼쪽회전, 오른쪽 회전, 한칸 이동
    명령 에러:
    1. 벽에 부딪힘
    2. 다른 로봇에 부딪힘
     */


    @Override
    public void test() throws ParseException, IOException {
        boolean isError = false;
        String result = "OK";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Ground ground = new Ground(a, b);
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            ground.putRobot(new Robot(i + 1, new Position(x, y), Direction.valueOf(direction), ground));
        }
        for (int i = 0; i < m; i++) {
            if(isError) {
                break;
            }
            st = new StringTokenizer(br.readLine());
            int robotNumber = Integer.parseInt(st.nextToken());
            char command = st.nextToken().charAt(0);
            int repeat = Integer.parseInt(st.nextToken());
            //로봇을 배열로 관리해야 함
            Robot robot = ground.getRobotFromList(robotNumber);

            for (int j = 0; j < repeat; j++) {
                if(isError) {
                    break;
                }
                try {
                    robot.command(command);
                } catch (Robot.DuplicatePostionException e) {
                    result = "Robot " + robot.number + " crashes into robot " + e.getMessage();
                    isError = true;
                } catch (IllegalArgumentException e) {
                    result = "Robot " + robot.number + " crashes into the wall";
                    isError = true;
                }
            }
        }
        System.out.println(result);
    }

    static class Ground {
        private HashMap<Integer, Robot> robotList = new HashMap<>();

        private final ArrayList<ArrayList<Robot>> robots = new ArrayList<>();

        public Ground(int x, int y) {
            for (int i = 0; i < x; i++) {
                robots.add(new ArrayList<>());
                for (int j = 0; j < y; j++) {
                    robots.get(i).add(null);
                }
            }
        }

        public void putRobot(Robot robot) {
            if (!validatePosition(robot.position)) {
                throw new IllegalArgumentException("존재하지 않는 위치입니다.");
            }
            int corX = robot.position.x - 1;
            int corY = robot.position.y - 1;

            if (robots.get(corX).get(corY) != null) {
                throw new IllegalArgumentException("로봇이 이미 존재합니다.");
            }
            robots.get(corX).set(corY, robot);
            robotList.put(robot.number, robot);
        }

        public Robot getRobot(Position position) {
            if (!validatePosition(position)) {
                throw new IllegalArgumentException("존재하지 않는 위치입니다.");
            }
            int corX = position.x - 1;
            int corY = position.y - 1;
            return robots.get(corX).get(corY);
        }

        public void removeRobot(Robot robot) {
            if (!validatePosition(robot.position)) {
                throw new IllegalArgumentException("존재하지 않는 위치입니다.");
            }
            int corX = robot.position.x - 1;
            int corY = robot.position.y - 1;
            if (robots.get(corX).get(corY) == null) {
                throw new IllegalArgumentException("로봇이 존재하지 않습니다.");
            }
            robots.get(corX).set(corY, null);
        }

        private boolean validatePosition(Position position) {
            if (position.x < 1 || position.y < 1 || position.x > robots.size() || position.y > robots.get(0).size()) {
                return false;
            }
            return true;
        }

        public Robot getRobotFromList(int robotNumber) {
            return robotList.get(robotNumber);
        }
    }

    static class Robot {

        Ground ground;
        int number;
        private final Position position;
        private Direction direction;

        String status = "OK";

        public Robot(int number, Position position, Direction direction, Ground ground) {
            this.number = number;
            this.position = position;
            this.direction = direction;
            this.ground = ground;
        }

        public Direction getDirection() {
            return direction;
        }

        public void command(char l) throws DuplicatePostionException {
            if (l == 'L') {
                this.direction = Direction.values()[(direction.value + 3) % 4];
            } else if (l == 'R') {
                this.direction = Direction.values()[(direction.value + 1) % 4];
            } else if (l == 'F') {
                ground.removeRobot(this);
                if (direction == Direction.N) {
                    position.y++;
                } else if (direction == Direction.E) {
                    position.x++;
                } else if (direction == Direction.S) {
                    position.y--;
                } else if (direction == Direction.W) {
                    position.x--;
                }
                if (position.x < 1 || position.y < 1 || position.x > ground.robots.size() || position.y > ground.robots.get(0).size()) {
                    throw new IllegalArgumentException("벽에 부딪혔습니다.");
                }
                if (ground.getRobot(position) != null) {
                    throw new DuplicatePostionException(String.valueOf(ground.getRobot(position).number));
                }
                ground.putRobot(this);
            } else {
                throw new IllegalArgumentException("잘못된 명령입니다.");
            }
        }

        public Position getPosition() {
            return this.position;
        }

        class DuplicatePostionException extends Throwable {

            public DuplicatePostionException(String s) {
                super(s);
            }
        }
    }

    static class Position {

        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    enum Direction {
        N(0), E(1), S(2), W(3);
        final int value;

        Direction(int value) {
            this.value = value;
        }
    }
}