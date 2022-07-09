package Algorithm.programmers.greedy;

import Algorithm.TestCase;

public class GymSuit implements TestCase {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        /*
        여분 체육복 기준으로 검색
        1. 줄 수 있는 방향 판별
        2. 1개면 넘겨주고 제외하기
        3. 못넘겨주면 없애기
        다 돌면 다시 한번 시도 -> 줄수 있는 체육복이 없어질 때 까지
        그리고 나서 LOST에 남아있나 확인

        체육복을 넘겨주거나 못주면 reserve에서 빼고, 넘겨받으면 lost에서 뺌
        최종적으로 n - lost.length로 리턴하면 됨됨
       */

        return answer;
    }
    @Override
    public void test() {
        int solution = solution(5, new int[]{2, 4}, new int[]{1, 3, 5});
        System.out.println("solution = " + solution);
    }
}
