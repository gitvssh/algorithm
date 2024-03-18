package algorithm.baek.bfs;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/1697
 * 숨바꼭질
 */
public class HideAndSeek implements TestCase {
    static BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
    static int[] visited = new int[100001];

    @Override
    public void test() throws ParseException, IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        solution(n, k);
        System.out.println(visited[k] - 1);

    }

    private void solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 1;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == k) {
                break;
            }
            if (x - 1 >= 0 && visited[x - 1] == 0) {
                queue.add(x - 1);
                visited[x - 1] = visited[x] + 1;
            }
            if (x + 1 <= 100000 && visited[x + 1] == 0) {
                queue.add(x + 1);
                visited[x + 1] = visited[x] + 1;
            }
            if (x * 2 <= 100000 && visited[x * 2] == 0) {
                queue.add(x * 2);
                visited[x * 2] = visited[x] + 1;
            }
        }
    }
}
