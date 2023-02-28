package algorithm.baek.backtracking;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14889
 * 스타트와 링크
 */
public class StartAndLink implements TestCase {
    static int[][] nums;
    static int n;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        nums = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(min);
    }

    static void dfs(int idx, int cnt) {
        if(cnt == n/2) {
            int start = 0;
            int link = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i] && visited[j]) {
                        start += nums[i][j];
                    }
                    if(!visited[i] && !visited[j]) {
                        link += nums[i][j];
                    }
                }
            }
            min = Math.min(min, Math.abs(start - link));
            return;
        }
        for (int i = idx; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
