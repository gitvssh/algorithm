package algorithm.baek.bfs;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16953
 * A → B
 */
public class AtoB implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int result = 0;
        result = bfs(a, b);
        System.out.println(result);
    }

    private int bfs(long start, long target) {
        Queue<Long> queue = new LinkedList<>();
        queue.add(start);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                long current = queue.poll();
                if (current == target) {
                    return count + 1;
                }
                if (current * 2 <= target) {
                    queue.add(current * 2);
                }
                if (current * 10 + 1 <= target) {
                    queue.add(current * 10 + 1);
                }
            }
            count++;
        }
        return -1;
    }
}
