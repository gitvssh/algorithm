package algorithm.programmers.codingtest.devmatch2022winter;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class BoxAround implements TestCase {
    static final int Y_LENGTH = 4;
    static final int X_LENGTH = 3;
    boolean[][] pos = new boolean[Y_LENGTH][X_LENGTH];
    boolean[][] visited = new boolean[Y_LENGTH][X_LENGTH];
    int[][] ways = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    int answer = 0;

    @Override
    public void test() throws ParseException, IOException {
        int solution = solution(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}});
        System.out.println(solution);
    }


    public int solution(int[][] phone) {
        for (int i = 0; i < Y_LENGTH; i++) {
            for (int j = 0; j < X_LENGTH; j++) {
                if (phone[i][j] == 1) {
                    pos[i][j] = true;
                }
            }
        }

        for (int i = 0; i < Y_LENGTH; i++) {
            for (int j = 0; j < X_LENGTH; j++) {
                if (pos[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j, 1);
                    visited[i][j] = false;
                }
            }
        }
        return answer;
    }

    public void dfs(int y, int x, int len) {
        if (len > 12) return;
        if (len > 1) answer++;
        for (int[] way : ways) {
            int ny = y + way[0];
            int nx = x + way[1];
            if (nx < 0 || ny < 0 || nx >= X_LENGTH || ny >= Y_LENGTH) continue;
            if (!pos[ny][nx]) continue;
            if (visited[ny][nx]) continue;
            visited[ny][nx] = true;
            dfs(ny, nx, len + 1);
            visited[ny][nx] = false;
        }
    }

}
