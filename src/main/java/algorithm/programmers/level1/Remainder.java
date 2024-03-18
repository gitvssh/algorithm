package algorithm.programmers.level1;

import algorithm.TestCase;

public class Remainder implements TestCase {
    public int solution(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 1) return i;
        }
        return -1;
    }

    @Override
    public void test() {
        solution(10);
    }
}
