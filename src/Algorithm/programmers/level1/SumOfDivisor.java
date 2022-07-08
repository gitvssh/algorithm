package Algorithm.programmers.level1;

import Algorithm.TestCase;

public class SumOfDivisor implements TestCase {
    public int solution(int n) {
        if(n==0) return 0;
        int answer = n;
        for (int i = 1; i <= n/2; i++) {
            if(n%i==0) answer+=i;
        }
        return answer;
    }
    @Override
    public void test() {
        int solution = solution(12);
        System.out.println("solution = " + solution);
    }
}
