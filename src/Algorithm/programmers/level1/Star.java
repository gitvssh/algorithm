package Algorithm.programmers.level1;

import Algorithm.TestCase;

public class Star implements TestCase {
    public static void solution(int a, int b) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < a; j++) {
            sb.append("*");
        }
        String s = sb.toString();
        for (int i = 0; i < b; i++) {
            System.out.println(s);
        }
    }

    @Override
    public void test() {
        int a = 5, b = 3;
        solution(a,b);
    }
}
