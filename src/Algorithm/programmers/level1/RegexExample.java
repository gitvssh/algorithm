package Algorithm.programmers.level1;

import Algorithm.TestCase;

import java.util.regex.Pattern;

public class RegexExample implements TestCase {
    public boolean solution(String s) {
        String pattern = "^[0-9]{4}$";
        String pattern2 = "^[0-9]{6}$";
        boolean isNumber = Pattern.matches(pattern, s);
        boolean isCorLen = Pattern.matches(pattern2,s);
        return isNumber || isCorLen;
    }
    @Override
    public void test() {
        boolean a234 = solution("12345");
        System.out.println("a234 = " + a234);
    }
}
