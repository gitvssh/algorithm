package algorithm.programmers.codingtest.devmatch2022;

import algorithm.TestCase;

/*
 * 뒤에서부터 빼는 방식으로 진행
 * 차이를 계속 더함
 * 2, 4,1,2 면
 * 2 -1 >= 0? 패스
 * 1 -4 >= 0? -3 3빼야됨
 * (4-3) - 2 >0 =? 1 ok
 * */
public class ProblemOne implements TestCase {

    public int solution(int[] grade) {
        int answer = 0;
        for (int i = grade.length - 2; i >= 0; i--) {
            int diff = checkDiff(grade[i + 1] - grade[i]);
            if (diff < 0) {
                grade[i] = grade[i] + diff;
                answer -= diff;
            }
        }
        return answer;
    }

    private int checkDiff(int diff1) {
        return Math.min(diff1, 0);
    }

    @Override
    public void test() {
        int[] testcase = new int[]{1, 2, 3};
        solution(testcase);
    }
}
