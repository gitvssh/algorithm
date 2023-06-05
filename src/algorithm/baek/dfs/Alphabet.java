package algorithm.baek.dfs;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1987
 * 알파벳
 * DFS
 */
public class Alphabet implements TestCase {
    static int R, C, max;
    static int[][] map = new int[20][20];
    static int[][] ways = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j) - 'A';
            }
        }
        max = 0;
        dfs(0, 0, 1, new boolean[26]);
        bw.write(max + "\n");
        bw.close();
    }

    private void dfs(int y, int x, int length, boolean[] visited) {
        visited[map[y][x]] = true;
        max = Math.max(max, length);
        for (int[] way : ways) {
            int nx = x + way[0];
            int ny = y + way[1];
            if (nx < 0 || ny < 0 || nx >= C || ny >= R) continue;
            if (visited[map[ny][nx]]) continue;
            dfs(ny, nx, length + 1, visited);
        }
        visited[map[y][x]] = false;
    }
}
