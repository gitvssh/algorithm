package algorithm.baek.brute;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2303
 * 숫자 게임
 * 브루트포스
 */
public class NumberGame implements TestCase {
    static int[] arr;
    static boolean[] visited;
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int maxIdx = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr = new int[5];
            visited = new boolean[5];
            for (int j = 0; j < 5; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int curMax = getMax(0, 0);
            if(max <= curMax){
                max = curMax;
                maxIdx = i + 1;
            }
        }
        System.out.println(maxIdx);
    }

    private int getMax(int cnt, int sum) {
        if (cnt == 3) {
            return sum % 10;
        }
        int max = 0;
        for (int i = 0; i < 5; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            max = Math.max(max, getMax(cnt + 1, sum + arr[i]));
            visited[i] = false;
        }
        return max;
    }
}
