package algorithm.baek.bfs;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/17144
 * 미세먼지 안녕!
 * BFS
 */
public class ByeByeDirt implements TestCase {
    static int R, C, T;

    static Room room;
    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static AirCleaner airCleaner;

    @Override
    public void test() throws ParseException, IOException {
        initMap();

        for (int i = 0; i < T; i++) {
            room.spread();
            airCleaner.cleaning(room);
        }
        int res = room.getDustAmount();
        bw.write(String.valueOf(res));
        bw.close();
    }

    private void initMap() throws IOException {
        br = new BufferedReader(new java.io.InputStreamReader(System.in));
        bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int[][] tmpMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int value = Integer.parseInt(st.nextToken());
                tmpMap[i][j] = value;
                if (value == -1) {
                    airCleaner = new AirCleaner(i, j);
                }
            }
        }

        room = new Room(tmpMap);
    }

    class Room {
        private int[][] map;

        public Room(int[][] map) {
            this.map = map;
        }

        public void spread() {
            int[][] tmpMap = new int[R][C];
            for (int i = 0; i < R; i++) {
                tmpMap[i] = Arrays.copyOf(map[i], C);
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    int wayCount = 0;

                    for (int[] dir : dirs) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                        if (tmpMap[nx][ny] == -1) continue;
                        wayCount++;
                    }
                    int dividedDust = map[i][j] / 5;
                    int remainDust = dividedDust * wayCount;
                    for (int[] dir : dirs) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                        if (tmpMap[nx][ny] == -1) continue;
                        tmpMap[nx][ny] += dividedDust;
                    }
                    tmpMap[i][j] -= remainDust;
                }
            }
            this.map = tmpMap;
        }

        public int getDustAmount() {
            int dustAmount = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    dustAmount += map[i][j];
                }
            }
            return dustAmount + 2;
        }

        public void setMap(int[][] map) {
            this.map = map;
        }

        public int[][] getMap() {
            return this.map;
        }

        public void printMap() {
            for (int[] ints : map) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        }
    }

    class AirCleaner {
        int x;
        int y;

        public AirCleaner(int y, int x) {
            this.x = x;
            this.y = y;
        }

        public int[][] cleaningUp(Room room) {
            int[][] tmpMap = room.getMap();
            int curX = this.x;
            int curY = this.y - 1;
            // 1. 위로
            for (int nextY = curY; nextY > 0; nextY--) {
                tmpMap[nextY][curX] = tmpMap[nextY - 1][curX];
            }
            tmpMap[curY][curX] = -1;
            // 2. 오른쪽으로
            for (int nextX = curX; nextX < C - 1; nextX++) {
                tmpMap[0][nextX] = tmpMap[0][nextX + 1];
            }
            // 3. 아래로
            for (int nextY = 0; nextY < curY; nextY++) {
                tmpMap[nextY][C-1] = tmpMap[nextY + 1][C-1];
            }
            // 4. 왼쪽으로
            for (int nextX = C - 1; nextX > 1; nextX--) {
                tmpMap[curY][nextX] = tmpMap[curY][nextX - 1];
            }
            tmpMap[curY][1] = 0;
            tmpMap[curY][curX] = -1;
            return tmpMap;
        }

        public int[][] cleaningDown(Room room) {
            int[][] tmpMap = room.getMap();
            int x = this.x;
            int y = this.y;
            // 1. 아래로
            for (int i = y; i < R - 1; i++) {
                tmpMap[i][x] = tmpMap[i + 1][x];
            }
            // 2. 오른쪽으로
            for (int i = x; i < C - 1; i++) {
                tmpMap[R - 1][i] = tmpMap[R - 1][i + 1];
            }
            // 3. 위로
            for (int i = R - 1; i > y; i--) {
                tmpMap[i][C - 1] = tmpMap[i - 1][C - 1];
            }
            // 4. 왼쪽으로
            for (int i = C - 1; i > 1; i--) {
                tmpMap[y][i] = tmpMap[y][i - 1];
            }
            tmpMap[y][x] = -1;
            tmpMap[y][1] = 0;
            return tmpMap;
        }

        public void cleaning(Room room) {
            room.setMap(cleaningUp(room));
            room.setMap(cleaningDown(room));
        }
    }
}
