package algorithm.baek.bfs;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2178
 * 미로 탐색
 */
public class MazeSearch implements TestCase {
    static int[][] maze;
    static int[][] visited;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }
        visited = new int[n][m];
        visited[0][0] = 1;
        bfs(0, 0);
        System.out.println(visited[n - 1][m - 1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new java.util.LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] way : dir) {
                int nx = cur[0] + way[0];
                int ny = cur[1] + way[1];
                if (nx >= 0 && nx < maze.length && ny >= 0 && ny < maze[0].length) {
                    if (maze[nx][ny] == 1 && visited[nx][ny] == 0) {
                        visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
