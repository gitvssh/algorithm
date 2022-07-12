package Algorithm.programmers.level1;

import Algorithm.TestCase;

import java.util.Arrays;

public class Budget implements TestCase {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);
        int n = 0;
        for (int i = 0; i < d.length; i++) {
            sum += d[n];
            if(sum>budget) break;
            answer ++;
            n++;
        }
        return answer;
    }
    @Override
    public void test() {
        int solution = solution(new int[]{1, 3, 2, 5, 4}, 9);
        System.out.println("solution = " + solution);
    }
}