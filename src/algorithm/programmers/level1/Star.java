package algorithm.programmers.level1;

import algorithm.TestCase;

public class Star implements TestCase {
    public static void solution(int a) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < a; j++) {
            sb.append("*");
        }
    }

    @Override
    public void test() {
        int a = 5;
        solution(a);
    }
}
