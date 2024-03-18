package algorithm.programmers.level1;

import algorithm.TestCase;

import java.util.Stack;

public class Crain implements TestCase {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int temp;
        Stack<Integer> st = new Stack<>();

        for (int move : moves) {
            //깊이만 탐색, 위치는 정해져있음
            for (int j = 0; j < board.length; j++) {
                //없으면 한칸 아래로
                if (board[j][move - 1] == 0) continue;
                //있으면 임시값 저장
                temp = board[j][move - 1];
                //인형 뽑기
                //스택이 비어있지 않고, 바로 전 인형이 같으면 터짐
                if (!st.isEmpty() && st.peek() == temp) {
                    st.pop();
                    answer += 2;
                    board[j][move - 1] = 0;
                    break;
                }
                //아니면 쌓기
                st.push(board[j][move - 1]);
                board[j][move - 1] = 0;
                break;
            }
        }
        return answer;
    }

    @Override
    public void test() {
        int[][] board = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = new int[]{1, 5, 3, 5, 1, 2, 1, 4};
        solution(board, moves);
    }
}
