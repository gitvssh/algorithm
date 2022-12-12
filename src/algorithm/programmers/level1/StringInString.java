package algorithm.programmers.level1;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class StringInString implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        String s = "abcde";
        String t = "cd";
        System.out.println(solution(s, t));
    }
    public int solution(String s, String t) {
        return s.contains(t) ? 1 : 2;
    }
}
