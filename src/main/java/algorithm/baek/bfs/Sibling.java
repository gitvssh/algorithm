package algorithm.baek.bfs;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2644
 * 촌수계산
 * BFS
 */
public class Sibling implements TestCase {
    static ArrayList<ArrayList<Integer>> list;
    static boolean visit[];
    static int n, m, a, b, result;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        visit = new boolean[n + 1];
        result = -1;
        bfs(a, 0);
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private void bfs(int start, int depth) {
        if (start == b) {
            result = depth;
            return;
        }
        visit[start] = true;
        for (int i = 0; i < list.get(start).size(); i++) {
            int next = list.get(start).get(i);
            if (!visit[next]) {
                bfs(next, depth + 1);
            }
        }
    }
}
