package algorithm.programmers.level1;

import algorithm.TestCase;

import java.util.Arrays;

public class NumberArray implements TestCase {

    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr)
                .filter(a -> a % divisor == 0)
                .sorted()
                .toArray();
        if (answer.length == 0) return new int[]{-1};
        return answer;
    }

    @Override
    public void test() {
        int[] testcase = new int[]{5, 9, 7, 10};
        solution(testcase, 5);
    }
}
