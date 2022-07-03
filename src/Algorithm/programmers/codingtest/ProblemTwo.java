package Algorithm.programmers.codingtest;

import Algorithm.TestCase;

/*
복잡하게 안하고 수학적으로 계산해서 구현해도 될 것 같음
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

    public int[][] solution(int n, boolean horizontal) {
        int[][] answer = new int[n][n];
        answer[0][0] = 1;
        for (int i = 1; i < n; i++) {
            System.out.println("i = " + i);
            if(i%2==0){
                solve(answer,i,horizontal);
            }else{
                solve2(answer,i,horizontal);
            }
        }
        return answer;
    }

    //시계방향
    private void solve(int[][] answer, int i, boolean horizontal) {
        int n = i;//바운더리
        int start = (n*n);
        for (int j = 0; j < n; j++) {
            answer[n][j] = ++start;
            System.out.println("증가 answer[n][j] = " + answer[n][j]);
        }
        for (int j = n; j >= 0; j--) {
            answer[j][n] = ++start;
            System.out.println("감소 answer[j][n] = " + answer[j][n]);
        }
    }

    //반시계방향
    private void solve2(int[][] answer, int i, boolean horizontal) {
        int n = i;//바운더리
        int start = (n*n);
        for (int j = 0; j < n; j++) {
            answer[j][n] = ++start;
            System.out.println("감소 answer[j][n] = " + answer[j][n]);
        }
        for (int j = n; j >= 0; j--) {
            answer[n][j] = ++start;
            System.out.println("증가 answer[n][j] = " + answer[n][j]);
        }
    }

    @Override
    public void test() {
        int n = 4;
        boolean horizontal = true;
        int[][] solution = solution(n, horizontal);
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[0].length; j++) {
                System.out.println("[x , y] = [" + solution[i][j] + " , " + solution[i][j] + " ]");
            }
        }
    }
}
