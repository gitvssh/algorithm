package algorithm.baek.backtracking;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15649
 * N과 M (1)
 */
public class NM1 implements TestCase {

    public static int n;
    public static int m;
    public static int[] arr;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n];
        dfs(0);
        System.out.println(sb);
    }

    private void dfs(int depth) {
        if(depth==m) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[j]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int j = 0; j < n; j++) {
            if(!visited[j]) {
                visited[j] = true;
                arr[depth] = j+1;
                dfs(depth+1);
                visited[j] = false;
            }
        }
    }
}
