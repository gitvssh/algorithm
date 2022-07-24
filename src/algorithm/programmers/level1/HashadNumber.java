package algorithm.programmers.level1;

import algorithm.TestCase;

public class HashadNumber implements TestCase {
    public boolean solution(int x) {
        int a = x % 10;
        int b = x / 10 % 10;
        int c = x / 100 % 10;
        int d = x / 1000 % 10;
        return x % (a + b + c + d) == 0;
    }

    @Override
    public void test() {
        solution(10);
    }
}
