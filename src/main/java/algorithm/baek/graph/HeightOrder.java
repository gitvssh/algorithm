package algorithm.baek.graph;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;

public class HeightOrder implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            HeightUtil heightUtil = new HeightUtil(n, m);
            heightUtil.init(br);
            bw.write(String.valueOf(heightUtil.getResult()));
        }
    }
}

class HeightUtil {

    boolean[][] graph;
    int[] dist;
    int n;
    int m;

    public HeightUtil(int n, int m) {
        this.n = n;
        this.m = m;
        graph = new boolean[n + 1][n + 1];
        dist = new int[n + 1];
    }

    public void setGraph(int a, int b) {
        graph[a][b] = true;
    }

    public void floydWarshall() {
        for (int k = 1; k <= n; ++k) {
            for (int j = 1; j <= n; ++j) {
                for (int i = 1; i <= n; ++i) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }
    }

    public void setDist() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] || graph[j][i]) {
                    dist[i]++;
                }
            }
        }
    }

    public int getResult() {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == n - 1) {
                result++;
            }
        }
        return result;
    }

    public void init(BufferedReader br) throws IOException {
        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            setGraph(a, b);
        }
        floydWarshall();
        setDist();
    }
}


