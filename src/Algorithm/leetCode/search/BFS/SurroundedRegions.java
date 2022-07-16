package algorithm.leetcode.search.bfs;

import algorithm.TestCase;

public class SurroundedRegions implements TestCase {
    private final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m = 0;
    private int n = 0;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        char[][] res = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = checkBoard(board, i, j, res);
            }
        }
    }

    private char checkBoard(char[][] board, int i, int j, char[][] res) {
        // 이미 방문한 곳일 경우 탈출
        if (res[i][j] != 0) return res[i][j];
        //'X'일 경우 탈출
        if (board[i][j] == 'X') return 'X';
        //'O'일경우, 이어진 'O' 탐색
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x > m || y < 0 || y > n || board[x][n] == 'O') continue;

        }
        return 'O';
    }

    @Override
    public void test() {
        solve(new char[][]{{'x'}});
    }
}
