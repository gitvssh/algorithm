package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1005
 * ACM Craft
 * 위상정렬
 */
public class ACMCraft implements TestCase {
    static int[] time;
    static int[] dp;
    static int[][] graph;
    static int[] inDegree;
    static int N;
    static int K;
    static int W;
    static BufferedWriter bw;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            time = new int[N + 1];
            dp = new int[N + 1];
            graph = new int[N + 1][N + 1];
            inDegree = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                time[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a][b] = 1;
                inDegree[b]++;
            }
            W = Integer.parseInt(br.readLine());
            topologicalSort();

        }
        bw.flush();
        bw.close();
    }

    private void topologicalSort() throws IOException {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                dp[i] = time[i];
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= N; i++) {
                if (graph[cur][i] == 1) {
                    inDegree[i]--;
                    dp[i] = Math.max(dp[i], dp[cur] + time[i]);
                    if (inDegree[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }
        bw.write(dp[W] + "\n");
    }
}
