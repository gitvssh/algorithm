package algorithm.baek.dfs;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2606
 * 바이러스
 */
public class Virus implements TestCase {
    int[][] map;
    boolean[] visited;
    int cnt = 0;
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        dfs(1);
        System.out.println(--cnt);
    }

    private void dfs(int i) {
        visited[i] = true;
        cnt++;
        for (int j = 1; j < map.length; j++) {
            if (map[i][j] == 1 && !visited[j]) {
                dfs(j);
            }
        }
    }
}
