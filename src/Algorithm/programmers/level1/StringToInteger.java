package Algorithm.programmers.level1;

import Algorithm.TestCase;

public class StringToInteger implements TestCase {
    public int solution(String s) {
        return (s.substring(0)!="-")?Integer.parseInt(s):-Integer.parseInt(s.substring(1,s.length()));
    }
    @Override
    public void test() {
        int solution = solution("-1234");
        System.out.println("solution = " + solution);
    }
}
