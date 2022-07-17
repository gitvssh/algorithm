package algorithm.programmers.level1;

import algorithm.TestCase;

import java.util.regex.Pattern;

public class StringChange implements TestCase {
    private final String[] words = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    public int solution(String s) {
        for (int i = 0; i < 10; i++) {
            s=s.replace(words[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
    @Override
    public void test() {
        int one2 = solution("one2");
        System.out.println("one2 = " + one2);
    }
}
