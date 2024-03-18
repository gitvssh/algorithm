package algorithm.baek.bfs;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14502
 * 연구소
 * BFS
 */
public class Laboratory implements TestCase {
    static int[][] map;
    static BufferedReader br;
    static BufferedWriter bw;
    static int N, M;
    static StringTokenizer st;
    static int maxSafeArea = Integer.MIN_VALUE;

    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    @Override
    public void test() throws ParseException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        bw.write(String.valueOf(maxSafeArea));
        bw.close();
    }

    private void dfs(int wallCount) {
        if (wallCount == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCount + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private void bfs() {
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
            }
        }

        int[][] tempMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, tempMap[i], 0, M);
        }

        while(!queue.isEmpty()){
            Node now = queue.poll();
            int curX = now.x;
            int curY = now.y;

            for(int[] dir : dirs){
                int nextX = curX + dir[0];
                int nextY = curY + dir[1];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if(tempMap[nextX][nextY] == 0){
                    tempMap[nextX][nextY] = 2;
                    queue.add(new Node(nextX, nextY));
                }
            }
        }

        calcSafeArea(tempMap);
    }

    private void calcSafeArea(int[][] map) {
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    safeArea++;
                }
            }
        }
        if(safeArea > maxSafeArea) {
            maxSafeArea = safeArea;
        }
    }

    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
