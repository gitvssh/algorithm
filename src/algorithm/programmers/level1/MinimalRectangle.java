package algorithm.programmers.level1;

import algorithm.TestCase;

import java.util.Arrays;

public class MinimalRectangle implements TestCase {

    public int solution(int[][] sizes) {
        int i = Arrays.stream(sizes)
                .map(s -> {
                    if (s[0] < s[1]) {
                        int temp = s[0];
                        s[0] = s[1];
                        s[1] = temp;
                    }
                    return s;
                })
                .mapToInt(x -> x[0])
                .max()
                .orElse(0);
        int j = Arrays.stream(sizes)
                .map(s -> {
                    if (s[0] < s[1]) {
                        int temp = s[0];
                        s[0] = s[1];
                        s[1] = temp;
                    }
                    return s;
                })
                .mapToInt(x -> x[1])
                .max()
                .orElse(0);

        return i + j;
    }

    @Override
    public void test() {
        int[][] testcase = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        solution(testcase);
    }
}
