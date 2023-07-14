package algorithm.programmers.level2;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.Stack;

public class PairDelete implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        String s = "cdcd";
        System.out.println(solution(s));
    }

    public int solution(String s) {
        char[] chars = s.toCharArray();
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

        }
        if (stack.isEmpty()) {
            answer = 1;
        }
        return answer;
    }
}
