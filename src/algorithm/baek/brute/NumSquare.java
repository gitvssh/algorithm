package algorithm.baek.brute;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1051
 * 숫자 정사각형
 * 브루트포스
 */
public class NumSquare implements TestCase {
    static int n, m;
    static int[][] arr;
    static int max = 0;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        int min = Math.min(n, m);
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m - 1; x++) {
                for (int size = 1; size < min; size++) {
                    if (y + size < n && x + size < m) {
                        if (arr[y][x] == arr[y][x + size]
                                && arr[y][x] == arr[y + size][x]
                                && arr[y][x] == arr[y + size][x + size]) {
                            max = Math.max(max, (size + 1) * (size + 1));
                        }
                    }
                }
            }
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}

