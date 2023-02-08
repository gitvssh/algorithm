package algorithm.baek.dfs;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

public class Tetromino implements TestCase {
    int[][] ways = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][][] specialCase = {{{-1, 0}, {1, 0}, {0, 1}}, {{0, -1}, {0, 1}, {1, 0}}, {{0, -1}, {-1, 0}, {1, 0}}, {{0, -1}, {-1, 0}, {0, 1}}};
    boolean[][] visited;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result = Math.max(result, solve(matrix, i, j));
            }
        }
        System.out.println(result);
    }

    private int solve(int[][] matrix, int x, int y) {
        visited[x][y] = true;
        int result = dfs(matrix, x, y, 0, visited);
        visited[x][y] = false;

        for (int[][] ways : specialCase) {
            int val = matrix[x][y];
            boolean toggle = false;
            for (int[] way : ways) {
                int nx = x + way[0];
                int ny = y + way[1];
                if (nx < 0 || ny < 0 || nx >= matrix.length || ny >= matrix[0].length) {
                    toggle = true;
                    break;
                }
                val += matrix[nx][ny];
            }
            if (!toggle) result = Math.max(result, val);
        }
        return result;
    }

    private int dfs(int[][] matrix, int x, int y, int depths, boolean[][] visited) {
        int res = 0;
        if (depths == 3) {
            return matrix[x][y];
        }

        for (int i = 0; i < ways.length; i++) {
            int nx = x + ways[i][0];
            int ny = y + ways[i][1];
            if (nx < 0 || ny < 0 || nx >= matrix.length || ny >= matrix[0].length) continue;
            if (visited[nx][ny]) continue;
            visited[nx][ny] = true;
            res = Math.max(res, dfs(matrix, nx, ny, depths + 1, visited));
            visited[nx][ny] = false;
        }
        return res + matrix[x][y];
    }


}
