package algorithm.baek.dfs;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 알고림 수업 - 깊이 우선 탐색 https://www.acmicpc.net/problem/24479
 */
public class DFSPractice implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            Graph graph = new Graph(n, m, start);
            graph.init(br);
            graph.dfs(start, new boolean[n + 1]);
            bw.write(graph.getResult());
        }
    }
}

class Graph {

    List<List<Integer>> graph;
    int start;
    int nodeCount;
    int edgeCount;
    boolean[] visited[];
    int[] visitOrder;
    int visitIndex;

    Graph(int v, int e, int s) {
        nodeCount = v;
        graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        visitOrder = new int[v + 1];
        this.edgeCount = e;
        this.start = s;
    }

    public void init(BufferedReader br) throws IOException {
        for (int i = 0; i < edgeCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
    }

    public void dfs(int node, boolean[] visited) {
        visited[node] = true;
        visitOrder[node] = ++visitIndex;
        List<Integer> integers = graph.get(node);
        integers.sort(Integer::compareTo);
        for (Integer nextNode : integers) {
            if (visited[nextNode]) {
                continue;
            }
            visited[nextNode] = true;
            dfs(nextNode, visited);
        }
    }

    public void bfs(int node) {
        boolean[] visited = new boolean[nodeCount];
        Queue queue = new LinkedList<Integer>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Integer cur = (Integer) queue.poll();
            visited[cur] = true;
            for (Integer nextNode : graph.get(cur)) {
                if (visited[nextNode]) {
                    continue;
                }
                visited[nextNode] = true;
                queue.offer(nextNode);
            }
        }
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < visitOrder.length; i++) {
            sb.append(visitOrder[i]).append("\n");
        }
        return sb.toString();
    }
}
