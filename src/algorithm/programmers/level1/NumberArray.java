package algorithm.programmers.level1;

import algorithm.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberArray implements TestCase {

    public int[] solution(int[] arr, int divisor) {
//        ArrayList<Integer> temp = new ArrayList<>();
//        for (int i : arr) {
//            if (i % divisor == 0) temp.add(i);
//        }
//        if (temp.size() == 0) return new int[]{-1};
//        return temp.stream()
//                .mapToInt(a -> a)
//                .sorted()
//                .toArray();
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
        int[] solution = solution(testcase, 5);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
