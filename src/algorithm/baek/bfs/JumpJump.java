package algorithm.baek.bfs;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1326
 * 폴짝폴짝
 * BFS
 */
public class JumpJump implements TestCase {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] arr = new int[10001];
    static int result = -1;
    @Override
    public void test() throws ParseException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bfs(start, end);
        bw.write(String.valueOf(result));
        bw.close();
    }

    private void bfs(int start, int end) {
        boolean[] visited = new boolean[arr.length];
        Queue<int[]> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int idx = poll[0];
            int power = arr[idx];

            while(true){
                idx += power;
                if (idx > arr.length) break;
                if(visited[idx]) continue;
                visited[idx] = true;

                if (idx == end) {
                    result = poll[1] + 1;
                    return;
                }
                queue.add(new int[]{idx, poll[1] + 1});
            }
            idx = poll[0];
            while(true){
                idx -= power;
                if (idx < 0) break;
                if(visited[idx]) continue;
                visited[idx] = true;

                if (idx == end) {
                    result = poll[1] + 1;
                    return;
                }
                queue.add(new int[]{idx, poll[1] + 1});
            }
        }

    }
}
