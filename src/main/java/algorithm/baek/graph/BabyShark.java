package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16236
 * 아기 상어
 */
public class BabyShark implements TestCase {

    static int[][] map;
    static int[][] visited;
    static int[][] ways = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    static int minX, minY, minDist;

    @Override
    public void test() throws ParseException, IOException {
        //1. 공간 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        Shark shark = null;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                //2. 상어 위치 찾기
                if (map[i][j] == 9) {
                    shark = new Shark(i, j, 2, 0, 0);
                    map[i][j] = 0;
                }
            }
        }
        while (true) {
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            minDist = Integer.MAX_VALUE;
            //3. 먹을 수 있는 물고기 찾기(가장 가까운 물고기)
            bfs(shark);
            //4. 먹을 수 있는 물고기가 없으면 종료
            if (minX == Integer.MAX_VALUE) break;
            //5. 먹을 수 있는 물고기가 있으면 먹기
            shark.eat();
            shark.move(minX, minY);
            shark.time += minDist;
            //6. 먹은 물고기 위치 0으로 변경
            map[minX][minY] = 0;

            //7. 3번으로 돌아가기
        }

        System.out.println(shark.time);


    }

    private void bfs(Shark shark) {
        int n = map.length;
        visited = new int[n][n];
        Queue<Shark> queue = new LinkedList<>();
        queue.add(shark);
        visited[shark.x][shark.y] = 0;
        while (!queue.isEmpty()) {
            Shark curr = queue.poll();
            for (int[] way : ways) {
                int nextX = curr.x + way[0];
                int nextY = curr.y + way[1];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;
                if (visited[nextX][nextY] > 0) continue;
                if (!curr.canMove(map[nextX][nextY])) continue;
                visited[nextX][nextY] = visited[curr.x][curr.y] + 1;
                Shark next = new Shark(curr);
                next.move(nextX, nextY);
                if (next.canEat(map[nextX][nextY])) {
                    if (visited[nextX][nextY] < minDist) {
                        minDist = visited[nextX][nextY];
                        minX = nextX;
                        minY = nextY;
                    } else if (visited[nextX][nextY] == minDist) {
                        if (nextX < minX) {
                            minX = nextX;
                            minY = nextY;
                        } else if (nextX == minX) {
                            if (nextY < minY) {
                                minY = nextY;
                            }
                        }
                    }
                }
                queue.add(next);
            }
        }

    }
}

class Shark {
    int x;
    int y;
    int size;
    int eat;
    int time;

    public Shark(int x, int y, int size, int eat, int time) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.eat = eat;
        this.time = time;
    }

    public Shark(Shark shark) {
        this.x = shark.x;
        this.y = shark.y;
        this.size = shark.size;
        this.eat = shark.eat;
        this.time = shark.time;
    }

    public void eat() {
        eat++;
        if (eat == size) {
            size++;
            eat = 0;
        }
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean canEat(int size) {
        return size != 0 && isBigger(size);
    }

    public boolean canMove(int size) {
        return size == 0 || (isSame(size) || isBigger(size));
    }

    private boolean isBigger(int size) {
        return this.size > size;
    }

    private boolean isSame(int size) {
        return this.size == size;
    }

    boolean isSmaller(int size) {
        return this.size < size;
    }

}
