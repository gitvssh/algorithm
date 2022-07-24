package algorithm.programmers.level1;

import algorithm.TestCase;

import java.util.Arrays;

public class Average implements TestCase {
    public double solution(int[] arr) {
        return Arrays.stream(arr)
                .average()
                .getAsDouble();
    }

    @Override
    public void test() {
        solution(new int[]{1, 2, 3, 4});
    }
}
