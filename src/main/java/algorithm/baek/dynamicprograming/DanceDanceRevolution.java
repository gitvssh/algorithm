package algorithm.baek.dynamicprograming;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/2342
 * Dance Dance Revolution
 * DP
 */
public class DanceDanceRevolution implements TestCase {
    static int[] move;
    static int[][][] dp;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        move = new int[line.length-1];
        for(int i=0; i<line.length-1; i++) {
            move[i] = Integer.parseInt(line[i]);
        }

        dp = new int[5][5][line.length];
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(solve(0, 0, 0));
    }

    static int solve(int left, int right, int cnt) {

        if (cnt == move.length) return 0;

        if (dp[left][right][cnt] != -1) return dp[left][right][cnt];

        dp[left][right][cnt] = Math.min(solve(move[cnt], right, cnt + 1) + energy(left, move[cnt]),
                solve(left, move[cnt], cnt + 1) + energy(right, move[cnt]));
        return dp[left][right][cnt];
    }

    static int energy(int pos, int des) {
        int num = Math.abs(pos - des);
        if (pos == 0) return 2;
        else if (num == 0) return 1;
        else if (num == 1 || num == 3) return 3;
        else return 4;
    }
}
