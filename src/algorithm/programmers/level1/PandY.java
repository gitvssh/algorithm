package algorithm.programmers.level1;

import algorithm.TestCase;

public class PandY implements TestCase {
    boolean solution(String s) {
        String pattern = "[^pPyY]";
        String s2 = s.replaceAll(pattern, "").toLowerCase();
        int count = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == 'p') {
                count++;
            } else {
                count--;
            }
        }
        return count == 0;
    }

    @Override
    public void test() {
        solution("pPoooyY");
    }
}
