package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/27172
 * 수 나누기 게임
 * 에라토스테네스의 체
 */
public class NumDivGame implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()), player[] = new int[N], maxCardNum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            maxCardNum = Math.max(maxCardNum, player[i] = Integer.parseInt(st.nextToken()));
        }

        int[] score = new int[N + 1], pos = new int[maxCardNum + 1];
        for (int i = 0; i < N; i++) pos[player[i]] = i + 1;

        for (int mod : player)
            for (int i = mod * 2; i <= maxCardNum; i += mod) {
                if (pos[i] != 0) {
                    score[pos[i]]--;
                    score[pos[mod]]++;
                }
            }
        for (int i = 1; i <= N; i++) sb.append(score[i]).append(" ");
        System.out.print(sb);
    }
}
