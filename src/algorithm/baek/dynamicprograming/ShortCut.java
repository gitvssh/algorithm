package algorithm.baek.dynamicprograming;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1446 지름길 다익스트라 알고리즘
 */
public class ShortCut implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        //변수 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        ArrayList<ShortCutNode> shortCuts = new ArrayList<>();

        //입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if (end > d) continue;
            if (end - start < distance) continue;
            shortCuts.add(new ShortCutNode(start, end, distance));
        }

        //정렬
        Collections.sort(shortCuts, new Comparator<ShortCutNode>() {
            @Override
            public int compare(ShortCutNode o1, ShortCutNode o2) {
                if(o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });

        //dp
        int[] dp = new int[d + 1];
        for (int i = 0; i <= d; i++) {
            dp[i] = i;
        }

        for (int i = 0; i <= d; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }
            for (ShortCutNode shortCut : shortCuts) {
                if (i == shortCut.end) {
                    dp[i] = Math.min(dp[i], dp[shortCut.start] + shortCut.distance);
                }
            }
        }
        bw.write(dp[d] + "\n");
        bw.close();
    }

    class ShortCutNode {

        int start;
        int end;
        int distance;

        ShortCutNode(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
}
