package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/18352
 * 특정 거리의 도시 찾기
 * BFS
 */
public class FindingDistanceOfCity implements TestCase {
    static int N, M, K, X;
    static int[][] map;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int INF = 200000000;
    static int[] distance;

    @Override
    public void test() throws ParseException, IOException {
        init();

        dijkstra(X);

        boolean isExist = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                bw.write(String.valueOf(i));
                bw.newLine();
                isExist = true;
            }
        }
        if (!isExist) {
            bw.write("-1");
        }
        bw.close();
    }

    private void dijkstra(int start) {
        distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            distance[i] = INF;
        }
        distance[start] = 0;

        for (int i = 1; i <= N; i++) {
            int min = INF + 1;
            int minIndex = -1;
            for (int j = 1; j <= N; j++) {
                if (!visited[j] && min > distance[j]) {
                    min = distance[j];
                    minIndex = j;
                }
            }
            visited[minIndex] = true;

            for (int j = 1; j <= N; j++) {
                if (!visited[j] && map[minIndex][j] != 0 && distance[j] > distance[minIndex] + map[minIndex][j]) {
                    distance[j] = distance[minIndex] + map[minIndex][j];
                }
            }
        }
    }

    private void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start][end] = 1;
        }

    }
}
