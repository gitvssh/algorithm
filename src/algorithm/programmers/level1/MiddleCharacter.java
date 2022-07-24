package algorithm.programmers.level1;

import algorithm.TestCase;

public class MiddleCharacter implements TestCase {
    public String solution(String s) {
        String answer;
        int n = s.length();
        answer = s.substring((n - 1) / 2, n / 2 + 1);
        return answer;
    }

    @Override
    public void test() {
        solution("abcd");
    }
}
