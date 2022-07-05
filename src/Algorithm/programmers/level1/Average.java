package Algorithm.programmers.level1;

import Algorithm.TestCase;

import java.util.Arrays;

public class Average implements TestCase {
    public double solution(int[] arr) {
        return Arrays.stream(arr)
                .average()
                .getAsDouble();
    }

    @Override
    public void test() {
        double solution = solution(new int[]{1, 2, 3, 4});
        System.out.println("solution = " + solution);
    }
}
