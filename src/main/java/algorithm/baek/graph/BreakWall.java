package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2206
 * 벽 부수고 이동하기
 */
public class BreakWall implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int[][] map = new int[n][m];
        int[][][] visited = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++)
                map[i][j] = line.charAt(j) - '0';
        }
        int res = bfs(map, visited, n, m);
        System.out.println(res);
    }

    public static int bfs(int[][] map, int[][][] visited, int n, int m) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = 1;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.x == n - 1 && node.y == m - 1) {
                return node.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (map[nx][ny] == 0 && visited[nx][ny][node.wall] == 0) {
                    visited[nx][ny][node.wall] = 1;
                    q.add(new Node(nx, ny, node.cnt + 1, node.wall));
                }
                if (map[nx][ny] == 1 && node.wall == 0) {
                    visited[nx][ny][1] = 1;
                    q.add(new Node(nx, ny, node.cnt + 1, 1));
                }
            }
        }
        return -1;

    }

    public static class Node {
        int x;
        int y;
        int cnt;
        int wall;

        public Node(int x, int y, int cnt, int wall) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.wall = wall;
        }
    }
}
