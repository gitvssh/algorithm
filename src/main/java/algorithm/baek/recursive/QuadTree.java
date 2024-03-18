package algorithm.baek.recursive;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/1992
 * 쿼드트리
 */
public class QuadTree implements TestCase {
    static int[][] arr;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(quadTree(arr, 0, 0, n));
    }

    public static String quadTree(int[][] arr, int x, int y, int size) {
        if(size == 1) {
            return String.valueOf(arr[x][y]);
        }
        StringBuilder sb = new StringBuilder();
        if (isSame(arr, x, y, size)) {
            return String.valueOf(arr[x][y]);
        } else {
            int newSize = size / 2;
            sb.append("(");
            sb.append(quadTree(arr, x, y, newSize));
            sb.append(quadTree(arr, x, y + newSize, newSize));
            sb.append(quadTree(arr, x + newSize, y, newSize));
            sb.append(quadTree(arr, x + newSize, y + newSize, newSize));
            sb.append(")");
        }
        return sb.toString();
    }

    public static boolean isSame(int[][] arr, int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[x][y] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
