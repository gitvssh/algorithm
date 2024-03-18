package algorithm.baek.bfs;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16928
 * 뱀과 사다리 게임
 */
public class SnakeAndLadder implements TestCase {

    static int visited[] = new int[101];
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        bfs(map);
    }

    public static void bfs(HashMap<Integer, Integer> map) {
        int start = 1;
        int end = 100;
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == end) {
                    System.out.println(count);
                    return;
                }
                for (int j = 1; j <= 6; j++) {
                    int next = curr + j;
                    if (next > end) break;
                    if (map.containsKey(next)) {
                        next = map.get(next);
                    }
                    if (visited[next] == 1) continue;
                    queue.add(next);
                    visited[next] = 1;
                }
            }
            count++;
        }
    }
}
