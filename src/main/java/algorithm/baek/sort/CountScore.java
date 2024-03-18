package algorithm.baek.sort;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/2822
 * 점수 계산
 */
public class CountScore implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int[] scores = {20, 30, 50, 48, 33, 66, 0, 64, 100, 0};
        int[] sortedScores = scores.clone();
        Arrays.sort(sortedScores);

        int sum = 0;
        for (int i = 3; i < 8; i++) {
            sum += sortedScores[i];
        }
        System.out.println(sum);

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == sortedScores[3] || scores[i] == sortedScores[4] || scores[i] == sortedScores[5] || scores[i] == sortedScores[6] || scores[i] == sortedScores[7]) {
                System.out.print(i + 1 + " ");
            }
        }
    }
}
