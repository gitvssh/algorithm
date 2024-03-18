package algorithm.programmers.dfs;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestGameMap implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int[][] maps = {{1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}};
        System.out.println(solution(maps));
    }
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] visited;
    int n, m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        visited[0][0] = 1;
        bfs(maps, visited);
        return visited[n - 1][m - 1] == 0 ? -1 : visited[n - 1][m - 1];
    }

    private void bfs(int[][] maps, int[][] visited) {
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] ways : dir) {
                int nx = cur[0] + ways[0];
                int ny = cur[1] + ways[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (maps[nx][ny] == 0 || visited[nx][ny] != 0) continue;
                visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                queue.add(new int[]{nx, ny});
            }
        }
    }

}
