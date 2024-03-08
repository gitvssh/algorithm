package algorithm.baek.etc;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * 주사위 게임 2
 * https://www.acmicpc.net/problem/5566
 */
public class DiceGame2 implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dice = new int[n];
        int[] move = new int[m];
        for (int i = 0; i < n; i++) {
            dice[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            move[i] = Integer.parseInt(br.readLine());
        }

        int pos = 0;
        for (int i = 0; i < m; i++) {
            pos += move[i];
            if (pos >= n - 1) {
                bw.write(i + 1 + "");
                break;
            }
            pos += dice[pos];
            if (pos >= n - 1) {
                bw.write(i + 1 + "");
                break;
            }
        }
        bw.close();
    }
}
