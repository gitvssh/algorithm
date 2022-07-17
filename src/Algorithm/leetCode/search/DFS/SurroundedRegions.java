package algorithm.leetcode.search.dfs;

import algorithm.TestCase;

public class SurroundedRegions implements TestCase {
    private final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m = 0;
    private int n = 0;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = checkBoard(board, i, j, visited);
            }
        }
        printBoard(board);
    }

    private void printBoard(char[][] board) {
        for (char[] re : board) {
            for (char c : re) {
                System.out.print(" , " + c);
            }
            System.out.println();
        }
    }

    private char checkBoard(char[][] board, int i, int j, int[][] visited) {
        // 이미 방문한 곳일 경우 탈출
//        System.out.println("탈출? = " + (res[i][j] != 0));
//        if((res[i][j] != 0)) System.out.println("탈출좌표 = "+ i + ',' +j);
        if (visited[i][j] != 0) return board[i][j];
//        System.out.println("탈출? = " + i + ',' +j);
        //'X'일 경우 탈출
        if (board[i][j] == 'X') return 'X';
        //'O'일 경우, 이어진 'O' 탐색
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n) {
                visited[i][j] = 2;
                return 'O';
            }
            board[x][y] = checkBoard(board, x, y, visited);
            visited[x][y] = (board[x][y]=='O')?2:1;
//            res[i][j] = 1;
//            System.out.println("res[x][y] = " + res[x][y]);
        }
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(visited[x][y]==2){
                visited[i][j]=2;
                return 'O';
            }
        }
        return 'X';
    }

    @Override
    public void test() {
//        solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
//        solve(new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}});
//        solve(new char[][]{{'X','O','X','O','O','O','O'},{'X','O','O','O','O','O','O'},{'X','O','O','O','O','X','O'},{'O','O','O','O','X','O','X'},{'O','X','O','O','O','O','O'},{'O','O','O','O','O','O','O'},{'O','X','O','O','O','O','O'}});
        solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
//        solve(new char[][]{{'O','O','O'},{'O','O','O'},{'O','O','O'}});
//        solve(new char[][]{{'X','O','X'},{'X','O','X'},{'X','O','X'}});
    }
}

