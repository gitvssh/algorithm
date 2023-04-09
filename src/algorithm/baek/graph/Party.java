package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1238
 * 파티
 */
public class Party implements TestCase {
    static int INF = 1000000000;
    private static List<List<Node>> list, reverseList;
    static int[] dist, reverseDist;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        reverseList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        dist = new int[n + 1];
        reverseDist = new int[n + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(reverseDist, INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(cost, to));
            reverseList.get(to).add(new Node(cost, from));
        }

        dijkstra(list, dist, x);
        dijkstra(reverseList, reverseDist, x);
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i] + reverseDist[i]);
        }
        System.out.println(max);
    }

    public static void dijkstra(List<List<Node>> list, int[] distance, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[list.size()];
        pq.add(new Node(0, start));
        distance[start] = 0;
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.node;
            if (visited[cur]) continue;
            visited[cur] = true;
            for (Node node : list.get(cur)) {
                if (distance[node.node] > distance[cur] + node.cost) {
                    distance[node.node] = distance[cur] + node.cost;
                    pq.add(new Node(distance[node.node], node.node));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int cost;
        int node;

        public Node(int cost, int node) {
            this.cost = cost;
            this.node = node;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
