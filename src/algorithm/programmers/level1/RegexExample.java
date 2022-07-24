package algorithm.programmers.level1;

import algorithm.TestCase;

import java.util.regex.Pattern;

public class RegexExample implements TestCase {
    public boolean solution(String s) {
        String pattern = "^\\d{4}$";
        String pattern2 = "^\\d{6}$";
        boolean isNumber = Pattern.matches(pattern, s);
        boolean isCorLen = Pattern.matches(pattern2,s);
        return isNumber || isCorLen;
    }
    @Override
    public void test() {
        solution("12345");
    }
}
