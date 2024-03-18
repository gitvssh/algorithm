package algorithm.baek.brute;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1025
 * 제곱수 찾기
 */
public class FindSquare implements TestCase {
    static int N, M;
    static int[][] map;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer((br.readLine()));
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        int rst = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                rst = Math.max(rst, findSquare(i, j));
            }
        }
        bw.write(String.valueOf(rst));
        bw.flush();
        bw.close();
    }

    private int findSquare(int i, int j) {
        int rst = -1;
        for (int x = -N; x < N; x++) {
            for (int y = -M; y < M; y++) {
                if (x == 0 && y == 0) continue;
                int num = 0;
                int nx = i;
                int ny = j;
                while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    num *= 10;
                    num += map[nx][ny];
                    if (isSquare(num)) {
                        rst = Math.max(rst, num);
                    }
                    nx += x;
                    ny += y;
                }
            }
        }
        return rst;
    }

    private boolean isSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
