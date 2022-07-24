package algorithm.programmers.level1;

import algorithm.TestCase;

public class KimInSeoul implements TestCase {
    public String solution(String[] seoul) {
        int index = -1;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                index = i;
                break;
            }
        }
        String format = "김서방은 %d에 있다";
        return String.format(format, index);
    }

    @Override
    public void test() {
        solution(new String[]{"Jane", "Kim"});
    }
}
