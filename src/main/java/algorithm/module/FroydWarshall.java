package algorithm.module;

public class FroydWarshall {

    static final int INF = Integer.MAX_VALUE;
    int[][] distance;

    public void froydWarshall(int[][] graph) {
        int n = graph.length;
        distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = graph[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(graph[i], 0, distance[i], 0, n);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int newDistance = distance[i][k] + distance[k][j];
                    if (newDistance < distance[i][j]) {
                        distance[i][j] = newDistance;
                    }

                }
            }
        }


    }

}
