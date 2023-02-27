package algorithm.baek.dfs;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1012
 * 유기농 배추
 */
public class Cabbage implements TestCase {
    static int[][] ways = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    static StringTokenizer st;
    static BufferedWriter bw;
    static BufferedReader br;

    @Override
    public void test() throws ParseException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            cnt = 0;
            setMap(br.readLine());
//            print();
            for (int j = 0; j < map.length; j++) {
                for (int k = 0; k < map[0].length; k++) {
                    if (map[j][k] == 1 && !visited[j][k]) {
//                        dfs(k, j);
                        bfs(k, j);
                        cnt++;
                    }
                }
            }
            bw.write(cnt + "\n");
        }
        bw.close();
    }
    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            visited[poll[1]][poll[0]] = true;
            for (int[] way : ways) {
                int nx = poll[0] + way[0];
                int ny = poll[1] + way[1];
                if (nx < 0 || ny < 0 || nx >= map[0].length || ny >= map.length) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] == 1) {
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void dfs(int x, int y) {
        visited[y][x] = true;
        for (int[] way : ways) {
            int nx = x + way[0];
            int ny = y + way[1];
            if (nx < 0 || ny < 0 || nx >= map[0].length || ny >= map.length) continue;
            if (visited[ny][nx]) continue;
            if (map[ny][nx] == 1) {
                dfs(nx, ny);
            }
        }
    }

    private static void print() throws IOException {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.write("\n");
    }

    public static void setMap(String str) throws IOException {
        st = new StringTokenizer(str);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
        }
    }
}
