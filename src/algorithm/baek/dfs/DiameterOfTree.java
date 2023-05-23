package algorithm.baek.dfs;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1167
 * 트리의 지름
 * dfs
 */
public class DiameterOfTree implements TestCase {
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int max = 0;
    static int node;
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(br.readLine());
        list = new ArrayList[lines+1];
        visited = new boolean[lines+1];
        for (int i = 0; i < lines; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            list[start] = new ArrayList<>();
            while (st.hasMoreTokens()) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                list[start].add(new Node(end, weight));
            }
        }
        dfs(1, 0);
        visited = new boolean[lines+1];
        dfs(node, 0);
        System.out.println(max);
//        int[][] map = new int[lines+1][lines+1];
//        for (int i = 0; i < lines; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int start = Integer.parseInt(st.nextToken());
//            while (st.hasMoreTokens()) {
//                int end = Integer.parseInt(st.nextToken());
//                if (end == -1) break;
//                int weight = Integer.parseInt(st.nextToken());
//                map[start][end] = weight;
//            }
//        }
//        int[] result = dfs(map, 1, new boolean[lines+1]);
//        result = dfs(map, result[0], new boolean[lines+1]);
//        System.out.println(result[1]);
    }

    private void dfs(int curIdx, int length) {
        visited[curIdx] = true;
        if (max < length) {
            max = length;
            node = curIdx;
        }
        for (Node node : list[curIdx]) {
            if (!visited[node.idx]) {
                dfs(node.idx, length + node.weight);
            }
        }
    }

//    private int[] dfs(int[][] map, int curIdx, boolean[] visited) {
//        visited[curIdx] = true;
//        int[] result = new int[]{curIdx, 0};
//        for (int j = 0; j < map.length; j++) {
//            if (map[curIdx][j] != 0 && !visited[j]) {
//                int[] temp = dfs(map, j, visited);
//                if (result[1] < temp[1] + map[curIdx][j]) {
//                    result[0] = temp[0];
//                    result[1] = temp[1] + map[curIdx][j];
//                }
//            }
//        }
//        return result;
//    }

    static class Node {
        int idx;
        int weight;
        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }
}
