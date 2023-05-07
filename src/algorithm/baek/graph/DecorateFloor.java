package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1388
 * 바닥 장식
 */
public class DecorateFloor implements TestCase {
    static char[][] floor;
    static boolean[][] visited;
    static int[][] dirs = {{0, 1}, {1, 0}};

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        floor = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            floor[i] = br.readLine().toCharArray();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public void bfs(int n, int m) {
        int curX = n;
        int curY = m;
        visited[curX][curY] = true;
        int[] dir = {};
        if (floor[curX][curY] == '-') {
            dir = dirs[0];
        } else if (floor[curX][curY] == '|') {
            dir = dirs[1];
        }
        int nextX = curX + dir[0];
        int nextY = curY + dir[1];
        if (nextX < 0 || nextX >= floor.length || nextY < 0 || nextY >= floor[0].length) return;
        if (floor[curX][curY] == floor[nextX][nextY]) {
            bfs(nextX, nextY);
        }
    }
}
