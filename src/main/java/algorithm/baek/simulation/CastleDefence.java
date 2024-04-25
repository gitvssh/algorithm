package algorithm.baek.simulation;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/17135
 * 백준 17135번 - 캐슬 디펜스
 */
public class CastleDefence implements TestCase {

    /*
    1. 격자판은 N x M 크기이다.
    2. 격자판의 N번행 바로 아래의 모든 칸에는 성이 있다.
    3. 성은 궁수 3명을 배치할 수 있다.
    4. 궁수는 성이 있는 칸에 배치할 수 있다.
    5. 각 턴마다 궁수는 적을 공격한다.
    6. 궁수는 거리가 D이하인 적 중에서 가장 가까운 적을 공격한다.
    7. 여러명의 적이 같은 거리에 있을 경우 가장 왼쪽에 있는 적을 공격한다.
    8. 공격받은 적은 게임에서 제외된다.
    9. 궁수의 공격이 끝나면 적이 아래로 한칸 이동한다.
    10. 적이 성이 있는 칸으로 이동하면 게임에서 제외된다.
    11. 모든 적이 제외되면 게임이 끝난다.
    12. 게임이 끝나면 적이 제외된 횟수를 출력한다.
    13. 격자판의 두 위치의 거리는 |r1 - r2| + |c1 - c2|이다.

    궁수
    1. 궁수는 성이 있는 칸에 배치할 수 있다.
    2. 궁수는 각 턴마다 적을 공격한다.
    3. 궁수는 거리가 D이하인 적 중에서 가장 가까운 적을 공격한다.
    4. 여러명의 적이 같은 거리에 있을 경우 가장 왼쪽에 있는 적을 공격한다.
    5. 공격받은 적은 게임에서 제외된다.

    적
    1. 적은 격자판의 최대 행 밖으로 이동하면 게임에서 제외된다.
    2. 적은 궁수의 공격이 끝나면 아래로 한칸 이동한다.
    3. 적이 성이 있는 칸으로 이동하면 게임에서 제외된다.
    4. 적은 게임 참여 상태를 가진다.

    게임
    1. 게임이 끝나면 적이 제외된 횟수를 출력한다.
    2. 모든 적이 제외되면 게임이 끝난다.
    3. 격자판의 두 위치의 거리는 |r1 - r2| + |c1 - c2|이다.
    4. 게임은 한 턴으로 구성되며 궁수의 공격이 끝나면 적이 이동한다.

    설계
    1. 궁수의 위치를 입력받아 시뮬레이션을 시행한다.
    2. 궁수의 위치를 조합으로 구한다.
    3. 동시 턴을 위하여 격자판과 적, 궁수는 분리하여 생각한다.

    요구사항
    o 게임은 격자판의 수와 궁수의 공격 제한거리를 입력받아 생성한다.
    o 게임은 궁수의 위치를 입력받아 시뮬레이션을 시행한다.
    o 시뮬레이션이 종료되면 적이 제거된 횟수를 기록한다.
    o 시뮬레이션은 제거할 수 있는 적의 최대 수를 출력할 수 있다.
    o 궁수는 적을 공격하여 게임에서 제외할 수 있다.
    o 적은 이동할 수 있다.
    o 적이 성이 있는 칸으로 이동하면 게임에서 제외된다.
    o 모든 적이 제외되면 게임이 종료된다.
    o 격자판의 두 위치의 거리는 |r1 - r2| + |c1 - c2|이다.
    - 시뮬레이션을 여러 번 수행하여 최대값을 구할 수 있다.
     */

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Game game = new Game(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        String[] map = new String[game.getMap().length];
        for (int i = 0; i < game.getMap().length; i++) {
            map[i] = br.readLine().trim();
        }
        game.init(map);
        System.out.println(game.doSimulation());
    }

    public static class Archer {

        private Position position;
        private int archerLimit;

        public Archer(Position archer1, int archerLimit) {
            this.position = archer1;
            this.archerLimit = archerLimit;
        }

        public Position getPosition() {
            return position;
        }

        public int getArcherLimit() {
            return archerLimit;
        }

        public Position attack(int[][] map) {
            int minDistance = Integer.MAX_VALUE;
            Position targetPosition = null;
            for (int y = 0; y < map.length; y++) {
                for (int x = 0; x < map[y].length; x++) {
                    if (!validDistance(new Position(y, x))) {
                        continue;
                    }
                    if (map[y][x] == 1) {
                        int distance = getDistance(new Position(y, x));
                        if (distance < minDistance) {
                            minDistance = distance;
                            targetPosition = new Position(y, x);
                        }else if(distance == minDistance){
                            if(targetPosition.getX() > x){
                                targetPosition = new Position(y, x);
                            }
                        }
                    }
                }
            }
            return targetPosition;
        }

        private boolean validDistance(Position targetPosition) {
            return getDistance(targetPosition) <= this.archerLimit;
        }

        private int getDistance(Position targetPosition) {
            return Math.abs(this.position.getX() - targetPosition.getX()) + Math.abs(this.position.getY() - targetPosition.getY());
        }
    }

    public static class Game {

        private int[][] map;
        private final int[][] originalMap;
        private int[][] tmpMap;
        private int archerLimit;
        private ArrayList<Archer> archers;

        private boolean isEndGame = false;

        private int maxEnermy;

        public Game(int y, int x, int archerLimit) {
            this.originalMap = new int[y][x];
            this.map = deepCopy(originalMap);
            this.tmpMap = new int[y][x];
            this.archerLimit = archerLimit;
            this.archers = new ArrayList<>();
        }

        public int[][] deepCopy(int[][] original) {
            if (original == null) {
                return null;
            }

            int[][] result = new int[original.length][original[0].length];

            for (int i = 0; i < original.length; i++) {
                System.arraycopy(original[i], 0, result[i], 0, original[i].length);
            }

            return result;
        }

        public int[][] getMap() {
            return map;
        }

        public int getArcherLimit() {
            return archerLimit;
        }

        public void setArcher(int archer1, int archer2, int archer3) {
            archers.add(new Archer(new Position(map.length, archer1), archerLimit));
            archers.add(new Archer(new Position(map.length, archer2), archerLimit));
            archers.add(new Archer(new Position(map.length, archer3), archerLimit));
        }

        public ArrayList<Archer> getArcher() {
            return archers;
        }

        public void run() {
            while(!isEndGame){
                tmpMap = deepCopy(map);
                for (Archer archer : archers) {
                    Position attack = archer.attack(map);
                    if(attack == null){
                        continue;
                    }
                    if (map[attack.getY()][attack.getX()] == 1 && tmpMap[attack.getY()][attack.getX()] == 1){
                        tmpMap[attack.getY()][attack.getX()] = 0;
                        maxEnermy++;
                    }
                }
                endTurn();
            }
        }

        public void init(String[] map) {
            for (int y = 0; y < map.length; y++) {
                String[] split = map[y].split(" ");
                for (int x = 0; x < split.length; x++) {
                    this.originalMap[y][x] = Integer.parseInt(split[x]);
                }
            }
            this.map = deepCopy(this.originalMap);
        }

        public void endTurn() {
            for (int y = 0; y < map.length - 1; y++) {
                for (int x = 0; x < map[0].length; x++) {
                    map[y + 1][x] = tmpMap[y][x];
                }
            }
            map[0] = new int[map[0].length];
            tmpMap = new int[map.length][map[0].length];
            if (checkEndGame()) {
                isEndGame = true;
            }
        }

        public boolean isEndGame() {
            return isEndGame;
        }

        public int getMaxEnermy() {
            return maxEnermy;
        }

        private boolean checkEndGame() {
            for (int y = 0; y < map.length; y++) {
                for (int x = 0; x < map[y].length; x++) {
                    if (map[y][x] == 1) {
                        return false;
                    }
                }
            }
            return true;
        }

        public int doSimulation() {
            boolean[] visited = new boolean[map[0].length];
            return combination(visited, 0, map[0].length, 3);
        }

        private int combination(boolean[] visited, int archerIndex, int indexSize, int remainItem) {
            if (remainItem == 0) {
                int[] archer = new int[3];
                int index = 0;
                for (int j = 0; j < visited.length; j++) {
                    if (visited[j]) {
                        archer[index++] = j;
                    }
                }
                clearGame();
                setArcher(archer[0], archer[1], archer[2]);
                run();
                System.out.println("archers position: " + Arrays.toString(archer) + " maxEnermy: " + maxEnermy);
                return maxEnermy;
            }

            if (archerIndex >= indexSize) {
                return 0;
            }

            visited[archerIndex] = true;
            // 현재 인덱스 포함 하는 경우
            int a = combination(visited, archerIndex + 1, indexSize, remainItem - 1);
            visited[archerIndex] = false;
            // 현재 인덱스 포함 하지 않는 경우
            int b = combination(visited, archerIndex + 1, indexSize, remainItem);
            return Math.max(a, b);
        }

        private void clearGame() {
            maxEnermy = 0;
            archers.clear();
            isEndGame = false;
            map = deepCopy(originalMap);
            tmpMap = deepCopy(map);
        }
    }

    public static class Position {
        private int x;
        private int y;

        Position(int y, int x){
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
