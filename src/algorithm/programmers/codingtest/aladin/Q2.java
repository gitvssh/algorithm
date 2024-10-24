package algorithm.programmers.codingtest.aladin;

import algorithm.TestCase;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Q2 implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        int[][] papres = {{1, 0, -1},
                {0, 0, -1},
                {1, 0, 2}};
        List<Paper> paperList = new ArrayList<>();
        for (int i = 0; i < papres.length; i++) {
            paperList.add(new Paper(papres[i][0], papres[i][1], papres[i][2], paperList.size() + 1))
            ;
        }

        Board board = new Board(400);
        board.attachPapersInOrder(paperList);
        int[][] result = board.board;
        for (int i = 0;i < result.length; i++) {
            System.out.println(result[i]);
        }


    }

    public class Paper {

        int x, y, d, order;

        public Paper(int x, int y, int d, int order) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.order = order;
        }
    }

    public class Board {

        int[][] board;
        int size;

        public Board(int size) {
            this.size = size * 2;
            this.board = new int[this.size][this.size];
        }

        public void attachPaper(Paper paper) {
            int s = Math.abs(paper.d);
            int x1 = paper.x + size / 2;
            int y1 = paper.y + size / 2;
            int x2 = x1 + (paper.d > 0 ? s : -s);
            int y2 = y1 + s;

            if (paper.d > 0) {
                for (int i = x1; i < x2; i++) {
                    for (int j = y1; j < y2; j++) {
                        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                            board[i][j] = paper.order;
                        }
                    }
                }
            } else {
                for (int i = x1; i < x2; i++) {
                    for (int j = y1; j < y1 + 2 * s; j++) {
                        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                            board[i][j] = paper.order;
                        }
                    }
                }
                for (int i = x1 - s; i < x1; i++) {
                    for (int j = y1 + s; j < y2; j++) {
                        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                            board[i][j] = paper.order;
                        }
                    }
                }
            }
        }

        public void attachPapersInOrder(List<Paper> papers) {
            for (Paper paper : papers) {
                attachPaper(paper);
            }
        }
    }
}
