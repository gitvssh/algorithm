package algorithm.baek.bfs;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/13549
 * 숨바꼭질 3
 */
public class HideAndSeek3 implements TestCase {
    static int[] time = new int[100001];
    static boolean[] visited = new boolean[100001];
    static int[] nextWeight = new int[]{1, -1, 2};
    static int N, K;


    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        if (N == K) {
            System.out.println(0);
            return;
        }

        Arrays.fill(time, Integer.MAX_VALUE);

        bfs();

        System.out.println(time[K]);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        time[N] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 2) {
                    next = now * nextWeight[i];
                } else {
                    next = now + nextWeight[i];
                }

                if (next < 0 || next > 100000) continue;

                if (time[next] > time[now] + (i == 2 ? 0 : 1)) {
                    time[next] = time[now] + (i == 2 ? 0 : 1);
                    queue.offer(next);
                }
            }
        }
    }
}
