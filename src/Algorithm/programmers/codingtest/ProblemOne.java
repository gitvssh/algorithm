package Algorithm.programmers.codingtest;

import Algorithm.TestCase;

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
        boolean change = false;
        for (int i = grade.length - 2; i >= 0; i--) {
            int diff = checkDiff(grade[i + 1] - grade[i]);
//            System.out.println("diff = " + diff);
//            System.out.println("grade[i] = " + grade[i]);
            if (diff < 0) {
                grade[i] =grade[i]+diff;
                answer -= diff;
            }
//            System.out.println("grade[i] = " + grade[i]);
//            System.out.println("answer = " + answer);
        }
        return answer;
    }

    private int checkDiff(int diff1) {
        int diff = diff1;
        return diff >= 0 ? 0 : diff;
    }

    @Override
    public void test() {
        int[] testcase = new int[]{1, 2, 3};
        int solution = solution(testcase);
        System.out.println("solution = " + solution);
    }
}
