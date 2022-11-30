package algorithm.leetcode.daily;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        String s = "]";
        System.out.println(isValid(s));
    }

    public boolean isValid(String s) {
        int n = s.length();

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else if (s.charAt(i) == ')') {
                if (stack.peek() == null || stack.pop() != '(') return false;
            } else if (s.charAt(i) == '}') {
                if (stack.peek() == null || stack.pop() != '{') return false;
            } else if (s.charAt(i) == ']') {
                if (stack.peek() == null || stack.pop() != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
