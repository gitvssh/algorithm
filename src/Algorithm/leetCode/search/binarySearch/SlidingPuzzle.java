package Algorithm.leetCode.search.binarySearch;

import Algorithm.TestCase;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0.
A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

Given the puzzle board board, return the least number of moves required so that the state of the board is solved.
If it is impossible for the state of the board to be solved, return -1.

*/
public class SlidingPuzzle implements TestCase {
    public int slidingPuzzle(int[][] board) {
        //1. 초기값 세팅
        String target = "123450";
        String start = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += board[i][j];
            }
        }

        HashSet<String> visited = new HashSet<>();
        int[][] dirs = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        Queue<String> queue = new LinkedList<>();

        //2. 시작점 지정
        queue.offer(start);
        visited.add(start);
        int res = 0;

        //3. 큐 빌 때 까지 루프
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                //탈출조건
                if (cur.equals(target)) {
                    return res;
                }
                //이동방향 탐색
                int zero = cur.indexOf('0');
                for (int dir : dirs[zero]) {
                    String next = swap(cur, zero, dir);
                    //캐시 체크
                    if (visited.contains(next)) {
                        continue;
                    }
                    queue.offer(next);
                    visited.add(next);
                }
            }
            res++;
        }
        return -1;
    }

    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    @Override
    public void test() {
//        int[][] board = {{1, 2, 3}, {4, 0, 5}};
        int[][] board = {{1, 2, 3}, {5, 4, 0}};
        int result = slidingPuzzle(board);
        System.out.println("result = " + result);
    }
}
