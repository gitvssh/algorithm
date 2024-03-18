package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11779
 * 최소비용 구하기 2
 * 다익스트라
 */
public class MinCost2 implements TestCase {

    static int n, m;
    static int INF = 1000000000;
    static int[] dist;
    static int[] path;
    static List<List<Node>> list;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        dist = new int[n + 1];
        path = new int[n + 1];
        Arrays.fill(dist, INF);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(cost, to));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        bw.write(dist[end] + "\n");

        List<Integer> result = new ArrayList<>();
        int cur = end;
        while (cur != start) {
            result.add(cur);
            cur = path[cur];
        }

        result.add(start);
        bw.write(result.size() + "\n");
        for (int i = result.size() - 1; i >= 0; i--) {
            bw.write(result.get(i) + " ");
        }
        bw.flush();
        bw.close();

    }

    private void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[list.size()];
        pq.add(new Node(0, start));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.node;
            if (visited[cur]) continue;
            visited[cur] = true;
            for (Node node : list.get(cur)) {
                if (dist[node.node] > dist[cur] + node.cost) {
                    dist[node.node] = dist[cur] + node.cost;
                    pq.add(new Node(dist[node.node], node.node));
                    path[node.node] = cur;
                }
            }
        }
    }

}

class Node implements Comparable<Node> {
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
