package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/1058
 * 친구
 */
public class Friend implements TestCase {
    static int N;
    static int[][] map;
    static int[][] dist;
    static int INF = 987654321;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);
                if (c == 'Y') map[i][j] = 1;
                else map[i][j] = INF;
            }
        }

        floydWarshall();

        int max = -1;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (dist[i][j] <= 2) cnt++;
            }
            max = Math.max(max, cnt);
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

    private void floydWarshall() {
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, dist[i], 0, N);
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}
