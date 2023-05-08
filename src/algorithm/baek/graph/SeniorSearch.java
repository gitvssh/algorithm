package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/3182
 * 한동이는 공부가 하기 싫어!
 */
public class SeniorSearch implements TestCase {
    @Override
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] senior = new int[n];
        for (int i = 0; i < n; i++) {
            senior[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int count = 0;
            int cur = i;
            while (true) {
                if (visited[cur]) break;
                visited[cur] = true;
                count++;
                cur = senior[cur] - 1;
                if (cur == i) break;
            }
            if (max < count) {
                max = count;
                maxIndex = i;
            }
        }
        System.out.println(maxIndex + 1);
    }
}
