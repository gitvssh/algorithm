package algorithm.programmers.level1;

import algorithm.TestCase;

import java.util.Stack;

public class Crain implements TestCase {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int temp = 0;
        Stack<Integer> st = new Stack<>();

        System.out.println("=============");
        for (int j = 0; j < board.length; j++) {
            for (int k = 0; k < board.length; k++) {
                System.out.print("[" + board[j][k] + "]");
            }
            System.out.println();
        }
        System.out.println("=============");

        for (int i = 0; i < moves.length; i++) {
            Integer peek = 0;
            if (!st.isEmpty()) peek = st.peek();
            System.out.println("최상단 인형 = " + peek);
            System.out.println("크레인 위치 = " + moves[i]);
            //깊이만 탐색, 위치는 정해져있음
            for (int j = 0; j < board.length; j++) {
                //없으면 한칸 아래로
                if (board[j][moves[i] - 1] == 0) continue;
                //있으면 임시값 저장
                temp = board[j][moves[i] - 1];
                //인형 뽑기
                System.out.println("뽑은 인형 = " + temp);
                //스택이 비어있지 않고, 바로 전 인형이 같으면 터짐
                if (!st.isEmpty()) {
                    if (st.peek() == temp) {
                        st.pop();
                        answer += 2;
                        board[j][moves[i] - 1] = 0;
                        System.out.println("인형 터짐");
                        break;
                    }
                }
                //아니면 쌓기
                st.push(board[j][moves[i] - 1]);
                board[j][moves[i] - 1] = 0;
                System.out.println("인형 쌓음");
                break;
            }
            System.out.println("=============");
            for (int j = 0; j < board.length; j++) {
                for (int k = 0; k < board.length; k++) {
                    System.out.print("[" + board[j][k] + "]");
                }
                System.out.println();
            }
            System.out.println("=============");
        }
        return answer;
    }

    @Override
    public void test() {
        int[][] board = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = new int[]{1, 5, 3, 5, 1, 2, 1, 4};
        int solution = solution(board, moves);
        System.out.println("solution = " + solution);
    }
}
