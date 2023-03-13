package algorithm.baek.dfs;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7576
 * 토마토
 * 1은 익은 토마토, 0은 익지 않은 토마토, -1은 토마토가 들어있지 않은 칸
 * 1. 입력받기
 * 2. bfs 탐색
 * 3. 익지 않은 토마토가 있는지 확인
 * 4. 익지 않은 토마토가 있으면 -1 출력
 * 5. 익지 않은 토마토가 없으면 최대값 출력
 * 6. 최대값이 1이면 0 출력
 */
public class Tomato implements TestCase {
    static int[][] ways = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] arr;
    static Queue<InTomato> queue = new LinkedList<>();

    @Override

    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1)
                    queue.add(new InTomato(i, j));
            }
        }
        bfs();
    }


    static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size(); // 큐에 있는 토마토의 개수
            for (int i = 0; i < size; i++) {
                InTomato tomato = queue.poll();
                int currX = tomato.x;
                int currY = tomato.y;
                for (int[] way : ways) {
                    int nextX = currX + way[0];
                    int nextY = currY + way[1];
                    // 범위를 벗어나는 경우 스킵
                    if (nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr[0].length) {
                        continue;
                    }
                    // 익지 않은 토마토(0)인 경우 익은 토마토(1)로 만들고 큐에 추가
                    if (arr[nextX][nextY] == 0) {
                        queue.add(new InTomato(nextX, nextY));
                        arr[nextX][nextY] = arr[currX][currY] + 1;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, arr[i][j]);
            }
        }
        if (max == 1) {
            System.out.println(0);
        } else {
            System.out.println(max - 1);
        }
    }

}

class InTomato {
    int x;
    int y;

    public InTomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}