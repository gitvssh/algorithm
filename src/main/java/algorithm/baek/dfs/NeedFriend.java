package algorithm.baek.dfs;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/21736
 * 헌내기는 친구가 필요해
 * 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
 */
public class NeedFriend implements TestCase {
    static char[][] map;
    static boolean[][] visited;
    static int N, M;
    static int count = 0;
    static int maxCount = 0;
    static int wallCount = 0;
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상우하좌

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        People dy = null;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'I') {
                    dy = new People(i, j);
                }
                if (map[i][j] == 'P') {
                    maxCount++;
                }
                if (map[i][j] == 'X') {
                    wallCount++;
                }
            }
        }
        if(wallCount == 0){
            bw.write(maxCount);
            bw.flush();
            bw.close();
            return;
        }

        dfs(dy);
        if (count == 0) {
            bw.write("TT");
        } else {
            bw.write(String.valueOf(count));
        }
        bw.flush();
        bw.close();
    }

    private void dfs(People dy) {
        if (map[dy.x][dy.y] == 'P') {
            count++;
        }
        if(count == maxCount){
            return;
        }
        if (count == maxCount) {
            System.out.println(count);
            System.exit(0);
        }
        visited[dy.x][dy.y] = true;
        for (int[] dir : dirs) {
            int nx = dy.x + dir[0];
            int ny = dy.y + dir[1];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (visited[nx][ny]) continue;
            if (map[nx][ny] == 'X') continue;
            dfs(new People(nx, ny));
        }
    }
}

class People {
    int x;
    int y;

    public People(int x, int y) {
        this.x = x;
        this.y = y;
    }
}