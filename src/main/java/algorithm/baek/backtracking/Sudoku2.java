package algorithm.baek.backtracking;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

public class Sudoku2 implements TestCase {
    static int[][] sudoku = new int[9][9];

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = line.charAt(j) - '0';
            }
        }
        dfs(0, 0);
    }

    private void dfs(int y, int x) {
        if (x == 9) {
            dfs(y + 1, 0);
            return;
        }
        if (y == 9) {
            for (int i = 0; i < 9; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]);
                }
                System.out.println(sb.toString());
            }
            System.exit(0);
        }

        if (sudoku[y][x] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isPossible(y, x, i)) {
                    sudoku[y][x] = i;
                    dfs(y, x + 1);
                }
            }
            sudoku[y][x] = 0;
            return;
        }
        dfs(y, x + 1);
    }

    private boolean isPossible(int y, int x, int i) {
        // x 중복 체크
        for (int j = 0; j < 9; j++) {
            if (sudoku[y][j] == i) {
                return false;
            }
        }
        // y 중복 체크
        for (int j = 0; j < 9; j++) {
            if (sudoku[j][x] == i) {
                return false;
            }
        }
        int ny = y / 3 * 3;
        int nx = x / 3 * 3;

        // 3x3 중복 체크
        for (int j = ny; j < ny + 3; j++) {
            for (int k = nx; k < nx + 3; k++) {
                if (sudoku[j][k] == i) {
                    return false;
                }
            }
        }
        return true;
    }
}
