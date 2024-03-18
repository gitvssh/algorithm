package algorithm.programmers.level1;

import algorithm.TestCase;

public class StrangeWord implements TestCase {
    public String solution(String s) {
        int cnt = 0;
        String[] split = s.split("");
        StringBuilder sb = new StringBuilder();
        for (String s1 : split) {
            //내부포문 다른방식
            cnt = s1.contains(" ") ? 0 : cnt + 1;
            sb.append((cnt % 2 == 0) ? (s1.toLowerCase()) : s1.toUpperCase());
        }
        return sb.toString();
    }

    @Override
    public void test() {
        solution("trasdfdfy helfdfsdflo worlwerwerd");
    }
}
