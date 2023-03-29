package algorithm.baek.dfs;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TomatoTower implements TestCase {
    static int[][] ways = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
    static int[][][] arr;
    static Queue<InTomatoTower> queue = new LinkedList<>();

    @Override

    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        arr = new int[length][width][height];
        for (int k = 0; k < height; k++) {
            for (int i = 0; i < length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < width; j++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1)
                        queue.add(new InTomatoTower(i, j, k));
                }
            }
        }


        bfs();
    }


    static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size(); // 큐에 있는 토마토의 개수
            for (int i = 0; i < size; i++) {
                InTomatoTower tomato = queue.poll();
                int currX = tomato.x;
                int currY = tomato.y;
                int currZ = tomato.z;
                for (int[] way : ways) {
                    int nextX = currX + way[0];
                    int nextY = currY + way[1];
                    int nextZ = currZ + way[2];
                    // 범위를 벗어나는 경우 스킵
                    if (nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr[0].length || nextZ < 0 || nextZ >= arr[0][0].length) {
                        continue;
                    }
                    // 익지 않은 토마토(0)인 경우 익은 토마토(1)로 만들고 큐에 추가
                    if (arr[nextX][nextY][nextZ] == 0) {
                        queue.add(new InTomatoTower(nextX, nextY, nextZ));
                        arr[nextX][nextY][nextZ] = arr[currX][currY][currZ] + 1;
                    }
                }
            }
        }

        int max = 0;
        for (int k = 0; k < arr[0][0].length; k++) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, arr[i][j][k]);
                }
            }
        }

        if (max == 1) {
            System.out.println(0);
        } else {
            System.out.println(max - 1);
        }
    }

}

class InTomatoTower {
    int x;
    int y;
    int z;

    public InTomatoTower(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}