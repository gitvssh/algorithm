package algorithm.baek.bfs;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/12851
 * 숨바꼭질 2
 */
public class HideAndSeek2 implements TestCase {
    static BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
    static int minTime = 987654321;
    static int cnt;
    static int[] time;

    @Override
    public void test() throws ParseException, IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        time = new int[100001];
        cnt = 0;
        if (n == k) {
            bw.write((n - k) + "\n");
            bw.flush();
            bw.close();
            return;
        }
        bfs(n, k);
        bw.write(minTime + "\n" + cnt);
        bw.flush();
        bw.close();
    }

    private void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        time[n] = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if(minTime < time[now]) {
                return;
            }

            for (int i=0; i<3; i++) {
                int next;

                if (i == 0)         next = now + 1;
                else if (i == 1)    next = now - 1;
                else                next = now * 2;

                if (next < 0 || next > 100000) continue;

                if (next == k) {
                    minTime = time[now];
                    cnt++;
                }

                if (time[next] == 0 || time[next] == time[now] + 1) {
                    queue.add(next);
                    time[next] = time[now] + 1;
                }
            }
        }
    }
}
