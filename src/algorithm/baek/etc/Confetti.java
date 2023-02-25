package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/2630
 * 색종이 만들기
 */
public class Confetti implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }
        int cnt[] = new int[2];
        countConfetti(arr, 0, 0, n, cnt);
        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
    }

    public static void countConfetti(int[][] arr, int x, int y, int size, int[] cnt) {
        if (isSame(arr, x, y, size)) {
            cnt[arr[x][y]]++;
        } else {
            int newSize = size / 2;
            countConfetti(arr, x, y, newSize, cnt);
            countConfetti(arr, x + newSize, y, newSize, cnt);
            countConfetti(arr, x, y + newSize, newSize, cnt);
            countConfetti(arr, x + newSize, y + newSize, newSize, cnt);
        }
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
