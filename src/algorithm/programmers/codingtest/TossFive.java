package algorithm.programmers.codingtest;

import algorithm.TestCase;

import java.util.Arrays;

public class TossFive implements TestCase {
    // 연속된 수 2,3개가 아닌 것 -1, ok면 총 개수

    public int solution(int[] tasks) {
        if (tasks.length == 1) return -1;
        Arrays.sort(tasks);

        int answer = 0;
        int cnt = 1;

        for (int i = 1; i < tasks.length; i++) {
            //cnt가 1이고, 다음 수가 다르면(1개가 연속이면) return -1
            if (cnt == 1 && tasks[i] != tasks[i - 1]) return -1;
            if (tasks[i] != tasks[i - 1]) {//초기화
                cnt = 1;
                //아니면 초기화때 answer ++
                answer++;
            } else {
                //cnt가 4가 넘으면 return -1
                cnt += 1;
                if (cnt > 3) return -1;
            }
        }
        if(cnt>1) answer++;
        return answer;
    }

    @Override
    public void test() {
        int solution = solution(new int[]{1, 1, 2, 2});
        System.out.println("solution = " + solution);
    }
}
