package algorithm.programmers.level1;

import algorithm.TestCase;

public class SumOfDivisor implements TestCase {
    public int solution(int n) {
        if (n == 0) return 0;
        int answer = n;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) answer += i;
        }
        return answer;
    }

    @Override
    public void test() {
        solution(12);
    }
}
