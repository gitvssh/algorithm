package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16724
 * 피리 부는 사나이
 */
public class PiedPiper implements TestCase {
    static int n, m;
    static char[][] map;
    static int[][] visited;
    static int cnt = 0;
    static int[][] group;
    static boolean[][] cycle;


    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 행
        m = Integer.parseInt(st.nextToken()); // 열
        map = new char[n][m];
        visited = new int[n][m];
        group = new int[n][m];
        cycle = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }

        int groupNum = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    dfs(i, j, groupNum);
                    groupNum++;
                }
            }
        }
        bw.write(groupNum - 1 + "\n");
        bw.flush();
        bw.close();
    }

    private void dfs(int y, int x, int groupNum) {
        visited[y][x] = 1;
        group[y][x] = groupNum;
        int ny = y;
        int nx = x;
        switch (map[y][x]) {
            case 'U':
                ny = y - 1;
                break;
            case 'D':
                ny = y + 1;
                break;
            case 'L':
                nx = x - 1;
                break;
            case 'R':
                nx = x + 1;
                break;
        }
        if (visited[ny][nx] == 1) {
            if (cycle[ny][nx] == false) {
                cnt++;
                cycle[ny][nx] = true;
                setCycle(ny, nx);
            }
        } else {
            dfs(ny, nx, groupNum);
        }
    }

    private void setCycle(int y, int x) {
        cycle[y][x] = true;
        int ny = y;
        int nx = x;
        switch (map[y][x]) {
            case 'U':
                ny = y - 1;
                break;
            case 'D':
                ny = y + 1;
                break;
            case 'L':
                nx = x - 1;
                break;
            case 'R':
                nx = x + 1;
                break;
        }
        if (cycle[ny][nx] == false) {
            setCycle(ny, nx);
        }
    }
}
