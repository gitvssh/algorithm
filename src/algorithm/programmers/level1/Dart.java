package algorithm.programmers.level1;

import algorithm.TestCase;

import java.util.Arrays;

public class Dart implements TestCase {
    public int solution(String dartResult) {
        int[] score = new int[3];
        String[] split = dartResult.split("");
        int n = 0;
        int i = 0;
        while (i < split.length) {
            //숫자면
            if (split[i].matches("[\\d]")) {
                if (Integer.parseInt(split[i]) == 0 && i != 0 && split[i - 1].matches("[\\d]")) {
                    score[n - 1] = 10;
                    i++;
                    continue;
                }
                score[n] = Integer.parseInt(split[i]);
                n++;
                //문자면
            } else if (split[i].matches("[A-Z]")) {
                switch (split[i]) {
                    case "D":
                        score[n - 1] = (int) Math.pow(score[n - 1], 2);
                        break;
                    case "T":
                        score[n - 1] = (int) Math.pow(score[n - 1], 3);
                        break;
                    case "S":
                    default:
                        break;
                }
                //보너스면
            } else {
                if (split[i].equals("*")) {
                    if (n == 1) {
                        score[0] *= 2;
                        i++;
                        continue;
                    }
                    score[n - 1] = score[n - 1] * 2;
                    score[n - 2] = score[n - 2] * 2;
                } else {
                    score[n - 1] = score[n - 1] * -1;
                }
            }

            i++;
        }
        return Arrays.stream(score).sum();
    }

    @Override
    public void test() {
        // remove print
    }
}
