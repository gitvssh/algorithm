package algorithm.programmers.level1;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class SlideStringTest implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        String a = "hellow";
        String b = "owhell";
        System.out.println(solution(a, b));
    }

    private int solution(String a, String b) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            sb.append(sb.charAt(sb.length()-1));
            sb.append(sb.toString(),0, a.length()-1);
            sb.delete(0,a.length());
            cnt++;
            if (sb.toString().equals(b)) return cnt;
        }
        return -1;
    }
}
