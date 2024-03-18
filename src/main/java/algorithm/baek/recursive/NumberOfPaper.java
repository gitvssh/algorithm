package algorithm.baek.recursive;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1780
 * 재귀 / 종이의 개수
 */
public class NumberOfPaper implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[] result = new int[3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, n, arr, result);
        for (int i = 0; i < 3; i++) {
            bw.write(result[i] + "\n");
        }
        bw.close();
    }

    private void divide(int x, int y, int size, int[][] matrix, int[] result) {
        if (check(x, y, size, matrix)) {
            result[matrix[x][y] + 1]++;
        } else {
            int nextSize = size / 3;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    divide(x + j * nextSize, y + k * nextSize, nextSize, matrix, result);
                }
            }
        }
    }

    private boolean check(int x, int y, int size, int[][] matrix) {
        int first = matrix[x][y];
        for (int j = x; j < x + size; j++) {
            for (int k = y; k < y + size; k++) {
                if (first != matrix[j][k]) return false;
            }
        }
        return true;
    }
}
