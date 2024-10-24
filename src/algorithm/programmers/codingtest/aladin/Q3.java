package algorithm.programmers.codingtest.aladin;

import algorithm.TestCase;

public class Q3 implements TestCase {

    @Override
    public void test() {
        int[][] board = {
                {3, 6, 8}
                , {1, 4, 7}
                , {2, 1, 4}
        };
        ChessBoard chessBoard = new ChessBoard(board);
        System.out.println("Max score: " + chessBoard.getMaxScore());
    }

    private class ChessBoard {
        private int[][] board;
        private int[] placement;
        private int maxScore;

        public ChessBoard(int[][] board) {
            this.board = board;
            this.placement = new int[board.length];
            this.maxScore = 0;
        }

        public int getMaxScore() {
            placeRooks(0);
            return maxScore;
        }

        private void placeRooks(int row) {
            if (row == board.length) {
                maxScore = Math.max(maxScore, calculateScore());
                return;
            }

            for (int col = 0; col < board.length; col++) {
                if (canPlace(row, col)) {
                    placement[row] = col;
                    placeRooks(row + 1);
                }
            }
        }

        private boolean canPlace(int row, int col) {
            for (int i = 0; i < row; i++) {
                if (placement[i] == col) {
                    return false;
                }
            }
            return true;
        }

        private int calculateScore() {
            int score = 0;
            for (int i = 0; i < board.length; i++) {
                score += board[i][placement[i]];
            }
            return score;
        }
    }
}
