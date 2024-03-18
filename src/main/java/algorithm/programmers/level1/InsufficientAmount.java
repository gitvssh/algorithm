package algorithm.programmers.level1;

import algorithm.TestCase;

public class InsufficientAmount implements TestCase {
    public long solution(int price, int money, int count) {
        return Math.max(price * (count * (count + 1) / 2) - money, 0);
    }

    @Override
    public void test() {
        solution(3, 20, 4);
    }
}
