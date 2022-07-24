package algorithm.programmers.level1;

import algorithm.TestCase;

public class NumberOfDigits implements TestCase {
    public int solution(int n) {
        int length = (int) Math.log10(n) + 1;
        int answer = 0;
        for (int i = 0; i < length; i++) {
            answer += n % 10;
            n /= 10;
        }
        return answer;
    }

    @Override
    public void test() {
        solution(123);
    }
}
