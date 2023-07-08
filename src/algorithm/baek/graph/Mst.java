package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1197
 * 최소 스패닝 트리
 * 최소 스패닝 트리
 * 크루스칼 알고리즘
 */
public class Mst implements TestCase {
    static int[] parent;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        quickSort(edges, 0, E - 1);
        int sum = 0;
        for (int i = 0; i < E; i++) {
            Edge edge = edges[i];
            if (!isSameParent(edge.from, edge.to)) {
                union(edge.from, edge.to);
                sum += edge.weight;
            }
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }

    private void quickSort(Edge[] edges, int i, int i1) {
        if (i >= i1) {
            return;
        }
        int pivot = partition(edges, i, i1);
        quickSort(edges, i, pivot - 1);
        quickSort(edges, pivot + 1, i1);
    }

    private int partition(Edge[] edges, int i, int i1) {
        int pivot = i1;
        int left = i;
        int right = i1 - 1;
        while (left <= right) {
            while (left <= right && edges[left].weight <= edges[pivot].weight) {
                left++;
            }
            while (left <= right && edges[pivot].weight <= edges[right].weight) {
                right--;
            }
            if (left < right) {
                swap(edges, left, right);
            }
        }
        swap(edges, left, pivot);
        return left;
    }

    private void swap(Edge[] edges, int left, int right) {
        Edge temp = edges[left];
        edges[left] = edges[right];
        edges[right] = temp;
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }
}

class Edge {
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}