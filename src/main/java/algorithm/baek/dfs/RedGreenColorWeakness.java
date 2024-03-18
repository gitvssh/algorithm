package algorithm.baek.dfs;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/10026
 * 적록색약
 */
public class RedGreenColorWeakness implements TestCase {
    private int[][] ways = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        boolean[][] visited = new boolean[n][n];
        boolean[][] visited2 = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int result = 0;
        int result2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    result++;
                    dfs(map, i, j, visited);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited2[i][j]) {
                    result2++;
                    dfs2(map, i, j, visited2);
                }
            }
        }
        System.out.println(result + " " + result2);
    }

    private void dfs2(char[][] map, int i, int j, boolean[][] visited2) {
        visited2[i][j] = true;
        for (int[] way : ways) {
            int nx = i + way[0];
            int ny = j + way[1];
            if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
            if (visited2[nx][ny]) continue;
            if (map[i][j] == 'R' || map[i][j] == 'G') {
                if (map[nx][ny] == 'R' || map[nx][ny] == 'G') {
                    dfs2(map, nx, ny, visited2);
                }
            } else {
                if (map[i][j] == map[nx][ny]) {
                    dfs2(map, nx, ny, visited2);
                }
            }
        }
    }

    private void dfs(char[][] map, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        for (int[] way : ways) {
            int nx = i + way[0];
            int ny = j + way[1];
            if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
            if (visited[nx][ny]) continue;
            if (map[i][j] == map[nx][ny]) {
                dfs(map, nx, ny, visited);
            }
        }
    }
}
