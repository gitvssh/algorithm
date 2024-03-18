package algorithm.baek.dfs;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.acmicpc.net/problem/2667
 * 단지번호붙이기
 */
public class Numbering implements TestCase {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] map;
    static boolean[][] visited;
    static HashMap<Integer, Integer> result;
    static int count = 0;
    static int[][] ways = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    @Override
    public void test() throws ParseException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        result = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    count++;
                    dfs(i, j, count);
                }
            }
        }
        bw.write(count + "\n");
        ArrayList<Integer> counts = new ArrayList<>(result.values());
        Collections.sort(counts);
        for (int c : counts) {
            bw.write(c + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int x, int y, int n) {
        visited[x][y] = true;
        map[x][y] = n;
        result.put(n, result.getOrDefault(n, 0) + 1);
        for (int[] way : ways) {
            int nx = x + way[0];
            int ny = y + way[1];
            if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
            if (visited[nx][ny]) continue;
            if (map[nx][ny] == 1) {
                dfs(nx, ny, n);
            }
        }

    }
}
