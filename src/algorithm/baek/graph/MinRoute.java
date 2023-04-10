package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1753
 * 최단경로
 */
public class MinRoute implements TestCase {

    static int v;
    static int[][] map;
    static int[] dist;
    static List<List<Node>> list;
    final int INF = 1000000;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        //1. 그래프 입력받기
        list = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }
        dist = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            dist[i] = INF;
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(cost, to));
        }
        //3. 데이크스트라 알고리즘 작성
        dijkstra(start);
        //4. 출력
        for (int i = 1; i <= v; i++) {
            if (dist[i] == INF) {
                bw.write("INF");
            } else {
                bw.write(dist[i] + "");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[v + 1];
        pq.add(new Node(0, start));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.node;
            for (Node node : list.get(cur)) {
                if (dist[node.node] > dist[cur] + node.cost) {
                    dist[node.node] = dist[cur] + node.cost;
                    pq.add(new Node(dist[node.node], node.node));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int node;
        int cost;

        public Node(int cost, int node) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
