package algorithm.programmers.level1;

import algorithm.TestCase;

public class StringToInteger implements TestCase {
    public int solution(String s) {
        return (s.charAt(0) != '-') ? Integer.parseInt(s) : -Integer.parseInt(s.substring(1));
    }

    @Override
    public void test() {
        solution("-1234");
    }
}
