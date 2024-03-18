package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/1996
 * 지뢰 찾기
 */
public class MineFinder implements TestCase {
    static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}};

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curX = i;
                int curY = j;
                if (map[curX][curY] != '.') {
                    result[curX][curY] = -1;
                    continue;
                }
                for (int[] d : dir) {
                    int nextX = curX + d[0];
                    int nextY = curY + d[1];
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                        if (map[nextX][nextY] != '.') {
                            int num = map[nextX][nextY]-'0';
                            int cur = result[curX][curY];
                            result[curX][curY] = cur + num;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(result[i][j] == -1) bw.write("*");
                else if(result[i][j] > 9) bw.write("M");
                else bw.write(result[i][j]+"");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
