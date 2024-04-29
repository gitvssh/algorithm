package algorithm.baek.simulation;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/18808
 * 백준 18808 스티커 붙이기
 */
public class PuttingSticker implements TestCase {

    /*
    예측:
    분석: 5m
    설계: 20m(구체적 해결방법까지)
    구현: 50m

    분석
    1. 스티커가 순서대로 주어진다.
    2. 왼쪽 위부터 시작하여 붙일 수 있는 공간을 찾아 붙인다.
    3. 붙이지 못할 경우, 90, 180, 270도 회전하여 찾아 붙인다.
    4. 실패 시 다음 스티커로 넘어간다.
    5. 모든 스티커를 붙인 후, 붙인 칸의 개수를 출력한다.

    설계
    노트북
    o 노트북에는 스티커를 붙일 수 있다.
    o 노트북은 2차원 배열로 표현한다.
    o 노트북의 세로와 가로길이는 N(1 <= N <= 40), M(1 <= M <= 40) 으로 나타낸다.
    o 노트북은 스티커가 붙여진 칸의 개수를 구할 수 있다.
    o 노트북은 스티커를 붙일 수 있는지 확인할 수 있다.

    스티커
    o 스티커는 2차원 배열로 표현한다.
    o 스티커의 세로와 가로길이는 R(1 <= R <= 10), C(1 <= C <= 10) 으로 나타낸다.
    o 스티커는 시계방향으로 회전할 수 있다.
    o 스티커는 노트북에 붙일 수 있다.

    로직
    1. 정보 입력받기
    2. 스티커 갯수 만큼
        1. 스티커 붙이기 시도
            1. 안되면 90도 회전, 180도 회전, 270도 회전
        2. 안되면 다음 스티커로 넘어가기
    3. 붙인 칸의 개수 출력하기
     */

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N, M, K;
    ArrayList<Sticker> stickers = new ArrayList<>();
    StringTokenizer st;

    @Override
    public void test() throws ParseException, IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Notebook notebook = new Notebook(N, M);

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[][] graph = new int[R][C];
            for (int j = 0; j < R; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < C; k++) {
                    graph[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            stickers.add(new Sticker(graph));
        }

        notebook.puttingStickers(stickers);
        System.out.println(notebook.getStickerCount());
    }

    public static class Notebook {

        boolean[][] notebook;

        public Notebook(int y, int x) {
            if (y < 1 || y > 40 || x < 1 || x > 40) {
                throw new IllegalArgumentException();
            }
            notebook = new boolean[y][x];
        }

        public void puttingSticker(int targetY, int targetX, Sticker sticker) {
            int[][] graph = sticker.getGraph();
            for (int y = 0; y < graph.length; y++) {
                for (int x = 0; x < graph[0].length; x++) {
                    if (graph[y][x] == 1) {
                        this.notebook[y + targetY][x + targetX] = true;
                    }
                }
            }
        }

        public int getStickerCount() {
            int count = 0;
            for (int y = 0; y < notebook.length; y++) {
                for (int x = 0; x < notebook[0].length; x++) {
                    if (notebook[y][x]) {
                        count++;
                    }
                }
            }
            return count;
        }

        public boolean checkPuttingSticker(int y, int x, Sticker sticker) {
            int[][] graph = sticker.getGraph();
            //스티커 크기를 기준으로 점검
            for (int graphtY = 0; graphtY < graph.length; graphtY++) {
                for (int graphX = 0; graphX < graph[0].length; graphX++) {
                    if (y + graphtY >= notebook.length || x + graphX >= notebook[0].length) {
                        return false;
                    }
                    if (notebook[y + graphtY][x + graphX] && graph[graphtY][graphX] == 1) {
                        return false;
                    }
                }
            }
            return true;
        }

        public void puttingStickers(ArrayList<Sticker> stickers) {
            for (Sticker sticker : stickers) {
                boolean isPut = false;
                int rotateCount = 0;
                while (rotateCount < 4) {
                    if(isPut){
                        break;
                    }
                    for (int y = 0; y < notebook.length; y++) {
                        for (int x = 0; x < notebook[0].length; x++) {
                            if (checkPuttingSticker(y, x, sticker)) {
                                puttingSticker(y, x, sticker);
                                isPut = true;
                            }
                            if (isPut) {
                                break;
                            }
                        }
                        if (isPut) {
                            break;
                        }
                    }
                    sticker = sticker.rotate();
                    rotateCount++;
                }

            }
        }
    }

    public static class Sticker {

        private int[][] graph;

        public Sticker(int[][] ints) {
            this.graph = ints;
        }

        public int[][] getGraph() {
            return graph;
        }

        public Sticker rotate() {
            int y = graph.length;
            int x = graph[0].length;
            int[][] newGraph = new int[x][y];

            for (int newX = 0; newX < y; newX++) {
                for (int newY = 0; newY < x; newY++) {
                    newGraph[newY][(y - 1) - newX] = graph[newX][newY];
                }
            }

            return new Sticker(newGraph);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Sticker) {
                Sticker sticker = (Sticker) obj;
                for (int i = 0; i < graph.length; i++) {
                    for (int j = 0; j < graph[0].length; j++) {
                        if (graph[i][j] != sticker.graph[i][j]) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return false;
        }
    }
}
