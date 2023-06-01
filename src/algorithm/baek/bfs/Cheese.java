package algorithm.baek.bfs;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2638
 * 치즈
 * BFS
 */
public class Cheese implements TestCase {
    static int[][] map;
    static boolean[][] visited;
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int n, m, cheeseCnt, time;
    static boolean[][] air;
    ArrayList<int[]> meltingCheese = new ArrayList<>();

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        air = new boolean[n][m];
        cheeseCnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int pos = Integer.parseInt(st.nextToken());
                if (pos == 1) {
                    cheeseCnt++;
                }
                map[i][j] = pos;
            }
        }

        checkAir();

        while (cheeseCnt > 0) {
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (air[i][j]) continue;
                    int cnt = 0;
                    for (int[] dir : direction) {
                        int nx = j + dir[0];
                        int ny = i + dir[1];
                        if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                        if (air[ny][nx]) cnt++;
                    }
                    if (cnt >= 2) {
                        meltingCheese.add(new int[]{i, j});
                    }
                }
            }
            melt();
            time++;
        }
        System.out.println(time);
    }

    private void setAir(int y, int x) {
        air[y][x] = true;
        for (int[] dir : direction) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if (air[ny][nx]) continue;
            if (map[ny][nx] == 1) continue;
            setAir(ny, nx);
        }
    }

    private void checkAir() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && !air[i][j]) {
                    setAir(i, j);
                    return;
                }
            }
        }
    }

    private void melt() {
        cheeseCnt -= meltingCheese.size();
        for (int i = 0; i < meltingCheese.size(); i++) {
            int[] pos = meltingCheese.get(i);
            map[pos[0]][pos[1]] = 0;
            setAir(pos[0], pos[1]);
        }
        meltingCheese.clear();
    }
}