package algorithm.baek.graph;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WormHoleRefactor implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int tc = Integer.parseInt(br.readLine());
            for (int i = 0; i < tc; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int undirected = Integer.parseInt(st.nextToken());
                int directed = Integer.parseInt(st.nextToken());
                Graph graph = new Graph(v, undirected * 2 + directed);
                graph.init(br, undirected, directed);
                graph.bellmanFord(1);
                bw.write(!graph.isCycle ? "NO" : "YES");
                bw.newLine();
            }
        }
    }
}

class Graph {

    boolean isCycle;

    class Edge {

        /**
         * source
         */
        int s;
        int dest;
        int weight;

        Edge() {
            s = dest = weight = 0;
        }

        Edge(int s, int dest, int weight) {
            this.s = s;
            this.dest = dest;
            this.weight = weight;
        }
    }

    int V, E;
    /**
     * edge
     */
    ArrayList<Edge> e;

    Graph(int v, int en) {
        V = v;
        E = en;
        e = new ArrayList<>();
        isCycle = false;
    }

    public void init(BufferedReader br, int undirected, int directed) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < undirected; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            e.add(new Edge(src, dest, weight));
            e.add(new Edge(dest, src, weight));
        }
        for (int i = 0; i < directed; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            e.add(new Edge(src, dest, -weight));
        }
    }

    public void bellmanFord(int src) {
        Graph graph = this;
        int V = graph.V, E = graph.E;

        int[] dist = new int[V + 1];
        Arrays.fill(dist, 1000000000);
        dist[src] = 0;

        for (int i = 1; i <= V; i++) {
            for (int j = 0; j < E; j++) {
                Edge edge = graph.e.get(j);
                if (dist[edge.dest] > dist[edge.s] + edge.weight) {
                    dist[edge.dest] = dist[edge.s] + edge.weight;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            Edge edge = graph.e.get(i);
            if (dist[edge.dest] > dist[edge.s] + edge.weight) {
                isCycle = true;
            }
        }
    }
}

