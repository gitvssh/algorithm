package algorithm.programmers.level1;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class SlideStringTest implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        String a = "apple";
        String b = "elppa";
        System.out.println(solution(a, b));
    }

    private int solution(String a, String b) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        for (int i = 0; i < a.length(); i++) {
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            if (sb.toString().equals(b)) return 1;
        }
        return -1;
    }
}
