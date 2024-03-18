package algorithm.baek.sort;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2623
 * 음악프로그램
 * 위상정렬
 */
public class MusicProgram implements TestCase {
    static int N, M;
    static int[] inDegree;
    static int[][] graph;
    static int[] result;
    static int resultIdx;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가수의 수
        M = Integer.parseInt(st.nextToken()); // 보조 PD의 수
        inDegree = new int[N + 1];
        graph = new int[N + 1][N + 1];
        result = new int[N];
        resultIdx = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt - 1; j++) {
                int next = Integer.parseInt(st.nextToken());
                if (graph[prev][next] == 0) {
                    graph[prev][next] = 1;
                    inDegree[next]++;
                }
                prev = next;
            }
        }

        topologicalSort();

        if (resultIdx != N) {
            bw.write("0");
        } else {
            for (int i = 0; i < N; i++) {
                bw.write(result[i] + "\n");
            }
        }
        bw.close();
    }

    private void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            result[resultIdx++] = cur;
            for (int i = 1; i <= N; i++) {
                if (graph[cur][i] == 1) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) q.add(i);
                }
            }
        }
    }
}
