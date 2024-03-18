package algorithm.baek.sort;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1766
 * 문제집
 * 위상정렬
 */
public class Workbook implements TestCase {
    static int[] inDegree;
    static BufferedWriter bw;
    static ArrayList<ArrayList<Integer>> graph;

    static int N;
    static int M;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 문제의 수
        M = Integer.parseInt(st.nextToken()); // 정보의 개수
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        inDegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 먼저 푸는 문제
            int b = Integer.parseInt(st.nextToken()); // 나중에 푸는 문제
            graph.get(a).add(b);
            inDegree[b]++;
        }
        topologicalSort();

        bw.flush();
        bw.close();
    }

    public void topologicalSort() throws IOException {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            bw.write(now + " ");
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}
