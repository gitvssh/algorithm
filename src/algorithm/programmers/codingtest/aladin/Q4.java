package algorithm.programmers.codingtest.aladin;

import algorithm.TestCase;
import java.io.IOException;
import java.text.ParseException;

public class Q4 implements TestCase {


    @Override
    public void test() throws ParseException, IOException {
        String[] board = {
//                "AAAAA",
//                "AABAA",
//                "AAAAA",
//                "AAAAA",
//                "AAAAA"
                "BAA","ABB","ABB","AAA"
        };
        LargestDShape largestDShape = new LargestDShape(board);
        System.out.println("Max area: " + largestDShape.getMaxArea());
    }

    public class LargestDShape {

        private char[][] board;
        private int maxArea;

        private int[] INIT = {-1, -1};
        private int[] UP = {-1, 0};
        private int[] DOWN = {1, 0};
        private int[] LEFT = {0, -1};
        private int[] RIGHT = {0, 1};
        private int[][] dirs = {UP, DOWN, LEFT, RIGHT, INIT};

        public LargestDShape(String[] board) {
            this.board = new char[board.length][board[0].length()];
            for (int i = 0; i < board.length; i++) {
                this.board[i] = board[i].toCharArray();
            }
            this.maxArea = 0;
        }

        public int getMaxArea() {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    dfs(i, j, INIT, INIT, 0, 0, 0);
                }
            }
            return maxArea == 0 ? -1 : maxArea;
        }

        private void dfs(int row, int col, int[] initDir, int[] dir, int len1, int len2, int len3) {
            // 시작 방향 기록
            if (initDir == INIT) {
                dfs(row, col, UP, UP, len1, len2, len3);
                dfs(row, col, DOWN, DOWN, len1, len2, len3);
                dfs(row, col, LEFT, LEFT, len1, len2, len3);
                dfs(row, col, RIGHT, RIGHT, len1, len2, len3);
                return;
            }
            // 탈출 조건
            if (len1 != 0 && len1 == len3) {
                maxArea = Math.max(maxArea, (len1 + 1) * 2 + (len2 + 1));
                return;
            }
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            // 범위 체크
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[newRow].length) {
                return;
            }

            // 유효성 체크
            if (board[row][col] != board[newRow][newCol]) {
                return;
            }

            if (initDir == UP) {
                if (dir == UP) {
                    if (len1 < 2) {
                        dfs(newRow, newCol, initDir, UP, len1 + 1, len2, len3);
                    } else {
                        dfs(newRow, newCol, initDir, UP, len1 + 1, len2, len3);
                        dfs(newRow, newCol, initDir, LEFT, len1, len2 + 1, len3);
                        dfs(newRow, newCol, initDir, RIGHT, len1, len2 + 1, len3);
                    }
                } else if (dir == DOWN) {
                    dfs(newRow, newCol, initDir, DOWN, len1, len2, len3 + 1);
                } else {
                    if (len2 < 2) {
                        dfs(newRow, newCol, initDir, dir, len1, len2 + 1, len3);
                    } else {
                        dfs(newRow, newCol, initDir, DOWN, len1, len2, len3 + 1);
                        dfs(newRow, newCol, initDir, dir, len1, len2 + 1, len3);
                    }
                }
            } else if (initDir == DOWN) {
                if (dir == DOWN) {
                    if (len1 < 2) {
                        dfs(newRow, newCol, initDir, DOWN, len1 + 1, len2, len3);
                    } else {
                        dfs(newRow, newCol, initDir, DOWN, len1 + 1, len2, len3);
                        dfs(newRow, newCol, initDir, LEFT, len1, len2 + 1, len3);
                        dfs(newRow, newCol, initDir, RIGHT, len1, len2 + 1, len3);
                    }
                } else if (dir == UP) {
                    dfs(newRow, newCol, initDir, UP, len1, len2, len3 + 1);
                } else {
                    if (len2 < 2) {
                        dfs(newRow, newCol, initDir, dir, len1, len2 + 1, len3);
                    } else {
                        dfs(newRow, newCol, initDir, UP, len1, len2, len3 + 1);
                        dfs(newRow, newCol, initDir, dir, len1, len2 + 1, len3);
                    }
                }
            } else if (initDir == LEFT) {
                if (dir == LEFT) {
                    if (len1 < 2) {
                        dfs(newRow, newCol, initDir, LEFT, len1 + 1, len2, len3);
                    } else {
                        dfs(newRow, newCol, initDir, LEFT, len1 + 1, len2, len3);
                        dfs(newRow, newCol, initDir, UP, len1, len2 + 1, len3);
                        dfs(newRow, newCol, initDir, DOWN, len1, len2 + 1, len3);
                    }
                } else if (dir == RIGHT) {
                    dfs(newRow, newCol, initDir, RIGHT, len1, len2, len3 + 1);
                } else {
                    if (len2 < 2) {
                        dfs(newRow, newCol, initDir, dir, len1, len2 + 1, len3);
                    } else {
                        dfs(newRow, newCol, initDir, RIGHT, len1, len2, len3 + 1);
                        dfs(newRow, newCol, initDir, dir, len1, len2 + 1, len3);
                    }
                }
            } else if (initDir == RIGHT) {
                if (dir == RIGHT) {
                    if (len1 < 2) {
                        dfs(newRow, newCol, initDir, RIGHT, len1 + 1, len2, len3);
                    } else {
                        dfs(newRow, newCol, initDir, RIGHT, len1 + 1, len2, len3);
                        dfs(newRow, newCol, initDir, UP, len1, len2 + 1, len3);
                        dfs(newRow, newCol, initDir, DOWN, len1, len2 + 1, len3);
                    }
                } else if (dir == LEFT) {
                    dfs(newRow, newCol, initDir, LEFT, len1, len2, len3 + 1);
                } else {
                    if (len2 < 2) {
                        dfs(newRow, newCol, initDir, dir, len1, len2 + 1, len3);
                    } else {
                        dfs(newRow, newCol, initDir, LEFT, len1, len2, len3 + 1);
                        dfs(newRow, newCol, initDir, dir, len1, len2 + 1, len3);
                    }
                }
            }
        }
    }
}
