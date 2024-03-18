package algorithm.baek.recursive;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/2448
 * 별 찍기 - 11
 */
public class Star11 implements TestCase {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;

    @Override
    public void test() throws ParseException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        char[][] result = new char[n][n * 2 - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2 - 1; j++) {
                result[i][j] = ' ';
            }
        }

        star(result, 0, 0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2 - 1; j++) {
                bw.write(result[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void star(char[][] result, int y, int x, int size) {
        if (size == 3) {
            result[y][x + 2] = '*';
            result[y + 1][x + 1] = '*';
            result[y + 1][x + 3] = '*';
            result[y + 2][x] = '*';
            result[y + 2][x + 1] = '*';
            result[y + 2][x + 2] = '*';
            result[y + 2][x + 3] = '*';
            result[y + 2][x + 4] = '*';
        } else {
            star(result, y, x + size / 2, size / 2);
            star(result, y + size / 2, x, size / 2);
            star(result, y + size / 2, x + size, size / 2);
        }
    }
}
