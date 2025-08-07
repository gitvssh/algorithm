package algorithm.baek.graph;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DeathGame implements TestCase {

    int[][] map;
    boolean[][] visited;
    int[][] cost;
    int[] dx = {0, 1, 0, -1}; // 이동 방향 설정
    int[] dy = {-1, 0, 1, 0};

    /*
    분석(5m)
    설계(5m)
    구현(15m)

    - 배열로 지도 만들기
    - 다익스트라 알고리즘으로 거리 비용 계산하기
    - 500,500의 비용 출력

    - 지도를 입력할 수 있다.
    - 거리를 업데이트할 수 있다.
    - 거리를 출력할 수 있다.
     */
    @Override
    public void test() throws ParseException, IOException {
        makeMap(System.in);
        updateCost();
        System.out.println(getResult());
    }

    public void makeMap(InputStream in) throws IOException {
        map = new int[501][501];
        visited = new boolean[501][501];
        cost = new int[501][501];

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            updateDangerZone(x1, y1, x2, y2);
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            updateDeathZone(x1, y1, x2, y2);
        }
    }

    private void updateDeathZone(int x1, int y1, int x2, int y2) {
        int minX = Math.min(x1, x2);
        int maxX = Math.max(x1, x2);
        int minY = Math.min(y1, y2);
        int maxY = Math.max(y1, y2);
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                map[y][x] = -1;
            }
        }
    }

    private void updateDangerZone(int x1, int y1, int x2, int y2) {
        int minX = Math.min(x1, x2);
        int maxX = Math.max(x1, x2);
        int minY = Math.min(y1, y2);
        int maxY = Math.max(y1, y2);
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                if (map[y][x] != -1) {
                    map[y][x] = 1; // 위험 지역
                }
            }
        }
    }

    public void updateCost() {
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        queue.offer(new Point(0, 0, 0));

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int x = current.x;
            int y = current.y;

            if (visited[y][x]) {
                continue;
            }
            visited[y][x] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= 501 || ny >= 501 || map[ny][nx] == -1 || visited[ny][nx]) {
                    continue;
                }

                int newCost = cost[y][x] + getMapTileCost(nx, ny);
                if (newCost < cost[ny][nx]) {
                    cost[ny][nx] = newCost;
                    queue.offer(new Point(nx, ny, newCost));
                }
            }
        }
    }

    public int getMapTileCost(int x, int y) {
        return map[y][x];
    }

    public int getCost(int x, int y) {
        return cost[y][x];
    }

    public int getResult() {
        return getCost(500, 500) == Integer.MAX_VALUE ? -1 : getCost(500, 500);
    }
}

class Point {

    int x, y, cost;

    Point(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}