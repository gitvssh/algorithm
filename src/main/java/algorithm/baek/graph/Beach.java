package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

public class Beach implements TestCase {
    static int[][] dirsOdd = new int[][]{{-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};
    static int[][] dirsEven = new int[][]{{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, -1}, {1, 0}};

    static boolean[][] visited;
    static char[][] beach;
    static int count;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        beach = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            beach[i] = br.readLine().toCharArray();
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && beach[i][j] == '#') {
                    int[][] dirs = i % 2 == 0 ? dirsEven : dirsOdd;
                    bfs(i, j, dirs);
                }
            }
        }
        System.out.println(count);
    }

    private void bfs(int i, int j, int[][] dirs) {
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int nextX = i + dir[0];
            int nextY = j + dir[1];
            if (nextX < 0 || nextX >= beach.length || nextY < 0 || nextY >= beach[0].length) continue;
            if (beach[nextX][nextY] != '#') {
                count++;
            }
        }
    }
}
