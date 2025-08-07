package algorithm.baek.bfs;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/16946
 * 벽 부수고 이동하기 4
 * BFS
 */
public class MoveCrashWall implements TestCase {
    static int[][] map;
    static int[][] result;
    static int[][] group;
    static int groupIdx = 1;

    static HashMap<Integer, Integer> groupCnt;

    static boolean[][] visited;
    static int n, m;
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static BufferedReader br;
    static BufferedWriter bw;


    @Override
    public void test() throws ParseException, IOException {
        init();

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x] != 0) {
                    result[y][x] = addResult(y, x);
                }
            }
        }

        print();
        bw.flush();
        bw.close();
    }

    private void print() throws IOException {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                bw.write(result[y][x] + "");
            }
            bw.write("\n");
        }
    }

    private void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];
        group = new int[n][m];
        groupCnt = new HashMap<>();

        for (int y = 0; y < n; y++) {
            String line = br.readLine();
            for (int x = 0; x < m; x++) {
                map[y][x] = line.charAt(x) - '0';
            }
        }

        for (int y = 0; y < n; y++) {
            for (int i = 0; i < m; i++) {
                if (map[y][i] == 0 && !visited[y][i]) {
                    visited[y][i] = true;
                    group[y][i] = groupIdx;
                    groupCnt.put(groupIdx, bfs(y, i, groupIdx));
                    groupIdx++;
                }
            }
        }
    }

    public int bfs(int y, int x, int groupIdx) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        int cnt = 1;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int[] dir : dirs) {
                int ny = cur.y + dir[0];
                int nx = cur.x + dir[1];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (visited[ny][nx]) continue;
                visited[ny][nx] = true;
                if (map[ny][nx] == 0) {
                    group[ny][nx] = groupIdx;
                    q.add(new Node(ny, nx));
                    cnt++;
                }
            }
        }
        return cnt % 10;
    }

    public int addResult(int y, int x) {
        int cnt = 1;
        Set<Integer> set = new HashSet<>();
        for (int[] dir : dirs) {
            int ny = y + dir[0];
            int nx = x + dir[1];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (map[ny][nx] == 0) {
                int groupIdx = group[ny][nx];
                if (set.contains(groupIdx)) continue;
                set.add(groupIdx);
                cnt += groupCnt.get(groupIdx);
            }
        }
        return cnt % 10;
    }

    class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
