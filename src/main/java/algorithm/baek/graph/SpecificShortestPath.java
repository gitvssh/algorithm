package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1504
 * 특정한 최단 경로
 * 다익스트라
 */
public class SpecificShortestPath implements TestCase {
    static int N, M;
    static int[][] map;

    static int INF = 200000000;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    @Override
    public void test() throws ParseException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        initMap();

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result = Math.min(dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N), dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N));
        if (result >= INF) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(result));
        }
        bw.close();
    }

    private int dijkstra(int i, int v1) {
        int[] distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int j = 1; j <= N; j++) {
            distance[j] = INF;
        }
        distance[i] = 0;

        for (int j = 1; j <= N; j++) {
            int min = INF + 1;
            int minIndex = -1;
            for (int k = 1; k <= N; k++) {
                if (!visited[k] && distance[k] < min) {
                    min = distance[k];
                    minIndex = k;
                }
            }
            if (minIndex == -1) break;
            visited[minIndex] = true;
            for (int k = 1; k <= N; k++) {
                if (visited[k]) continue;
                if (map[minIndex][k] == 0) continue;
                if (distance[k] > distance[minIndex] + map[minIndex][k]) {
                    distance[k] = distance[minIndex] + map[minIndex][k];
                }
            }
        }
        return distance[v1];
    }

    private void initMap() throws IOException {
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[v1][v2] = cost;
            map[v2][v1] = cost;
        }
    }
}
