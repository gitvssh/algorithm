package Algorithm.programmers.level1;

import Algorithm.TestCase;

import java.util.Arrays;

public class OrderDigits implements TestCase {
    public long solution(long n) {
        String[] nArr = String.valueOf(n).split("");
        Arrays.sort(nArr);
        StringBuilder sb = new StringBuilder();
        for (int i = nArr.length - 1; i >= 0; i--) {
            sb.append(nArr[i]);
        }
        return Long.parseLong(sb.toString());
    }

    @Override
    public void test() {
        long solution = solution(118372);
        System.out.println("solution = " + solution);
    }
}
