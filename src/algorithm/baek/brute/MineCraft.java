package algorithm.baek.brute;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class MineCraft implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] ground = new int[n][m];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < ground.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                ground[i][j] = value;

                max = Math.max(max, value);
                min = Math.min(min, value);
            }
        }

        int answerSeconds = Integer.MAX_VALUE;
        int answerHeight = -1; // 층

        for (int i = min; i <= max; i++) {
            int seconds = 0;
            int inventory = b;

            for (int j = 0; j < ground.length; j++) {
                for (int k = 0; k < ground[j].length; k++) {
                    int diff = ground[j][k] - i;

                    if(diff > 0) {
                        seconds += Math.abs(diff) * 2;
                        inventory += Math.abs(diff);
                    }else if(diff < 0){
                        seconds += Math.abs(diff);
                        inventory -= Math.abs(diff);
                    }
                }
            }

            if(inventory >= 0) {
                if(seconds <= answerSeconds) {
                    answerSeconds = seconds;
                    answerHeight = i;
                }
            }
        }
        bw.write(answerSeconds + " " + answerHeight);
        bw.close();
    }
}
