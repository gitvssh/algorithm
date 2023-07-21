package algorithm.baek.dfs;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9466
 * 팀 프로젝트
 * dfs
 */
public class TeamProject implements TestCase {
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static int result;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    dfs(j);
                }
            }
            bw.write(String.valueOf(n - result));
            bw.newLine();
        }
        bw.close();
    }

    private void dfs(int start) {
        visited[start] = true;
        int next = arr[start];
        if (!visited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                for (int i = next; i != start; i = arr[i]) {
                    result++;
                }
                result++;
            }
        }
        finished[start] = true;
    }
}
