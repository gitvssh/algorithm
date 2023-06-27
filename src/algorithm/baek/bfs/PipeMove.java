package algorithm.baek.bfs;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/17070
 * 파이프 옮기기 1
 * BFS
 */
public class PipeMove implements TestCase {
    static int[][] map;
    static int[][] dirs = new int[][]{{0, 1}, {1, 0}, {1, 1}};
    static int N;
    static int res = 0;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(new Pipe(0, 1, Status.HORIZONTAL));

        bw.write(String.valueOf(res));
        bw.close();
    }

    private void dfs(Pipe pipe) {
        if (pipe.y == N - 1 && pipe.x == N - 1) {
            res++;
            return;
        }

        if (pipe.status == Status.HORIZONTAL) {
            if (pipe.canMoveRight(map)) {
                dfs(new Pipe(pipe.y, pipe.x + 1, Status.HORIZONTAL));
            }
            if (pipe.canMoveDiagonal(map)) {
                dfs(new Pipe(pipe.y + 1, pipe.x + 1, Status.DIAGONAL));
            }
        } else if (pipe.status == Status.VERTICAL) {
            if (pipe.canMoveDown(map)) {
                dfs(new Pipe(pipe.y + 1, pipe.x, Status.VERTICAL));
            }
            if (pipe.canMoveDiagonal(map)) {
                dfs(new Pipe(pipe.y + 1, pipe.x + 1, Status.DIAGONAL));
            }
        } else if (pipe.status == Status.DIAGONAL) {
            if (pipe.canMoveRight(map)) {
                dfs(new Pipe(pipe.y, pipe.x + 1, Status.HORIZONTAL));
            }
            if (pipe.canMoveDown(map)) {
                dfs(new Pipe(pipe.y + 1, pipe.x, Status.VERTICAL));
            }
            if (pipe.canMoveDiagonal(map)) {
                dfs(new Pipe(pipe.y + 1, pipe.x + 1, Status.DIAGONAL));
            }
        }
    }
}

class Pipe {
    int y;
    int x;
    Status status;

    public Pipe(int y, int x, Status status) {
        this.y = y;
        this.x = x;
        this.status = status;
    }

    void moveRight() {
        if (this.status == Status.DIAGONAL)
            this.status = Status.HORIZONTAL;
        this.x++;
    }

    void moveDown() {
        if (this.status == Status.DIAGONAL)
            this.status = Status.VERTICAL;
        this.y++;
    }

    void moveDiagonal() {
        if (this.status != Status.DIAGONAL)
            this.status = Status.DIAGONAL;
        this.x++;
        this.y++;
    }

    boolean canMoveRight(int[][] map) {
        if (this.x + 1 >= map.length)
            return false;
        if (map[this.y][this.x + 1] == 1)
            return false;
        return true;
    }

    boolean canMoveDown(int[][] map) {
        if (this.y + 1 >= map.length)
            return false;
        if (map[this.y + 1][this.x] == 1)
            return false;
        return true;
    }

    boolean canMoveDiagonal(int[][] map) {
        if (this.x + 1 >= map.length || this.y + 1 >= map.length)
            return false;
        if (map[this.y + 1][this.x] == 1 || map[this.y][this.x + 1] == 1 || map[this.y + 1][this.x + 1] == 1)
            return false;
        return true;
    }
}


enum Status {
    HORIZONTAL(0), VERTICAL(1), DIAGONAL(2);
    int value;

    Status(int value) {
        this.value = value;
    }
}