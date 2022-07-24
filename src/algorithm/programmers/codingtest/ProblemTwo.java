package algorithm.programmers.codingtest;

import algorithm.TestCase;

/*
복잡하게 안하고 수식으로 계산해서 구현해도 될 것 같음
시간절약 가능

n*n 정사각형임
수평이든 수직이든 답은 정해져있고, 매트릭스 대칭이동만 하면 똑같음
n은 500까지임

수평일 때
1, 1+1, n^2, n^+1,

1  2   9 10
4  3   8 11
5  6   7 12
16 15 14 13

짝수면 이전 +1, 홀수면 n^2 ㄴㄴㄴ
n*n 이하면,(한번의 청소면)
홀수 - 증가 채우기, 짝수 - 감소 채우기

그냥 구현하는게 더 빠를듯

for i
    for j
        i까지 이동하면서 +1
        j까지 이동하면서 -


 * */
public class ProblemTwo implements TestCase {

    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        answer[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                solve(answer, i);
            } else {
                solve2(answer, i);
            }
        }
        return answer;
    }

    //시계방향
    private void solve(int[][] answer, int i) {
        int start = (i * i);
        for (int j = 0; j < i; j++) {
            answer[i][j] = ++start;
        }
        for (int j = i; j >= 0; j--) {
            answer[j][i] = ++start;
        }
    }

    //반시계방향
    private void solve2(int[][] answer, int i) {
        int start = (i * i);
        for (int j = 0; j < i; j++) {
            answer[j][i] = ++start;
        }
        for (int j = i; j >= 0; j--) {
            answer[i][j] = ++start;
        }
    }

    @Override
    public void test() {
        int n = 4;
        solution(n);
    }
}
