package algorithm.programmers.level0;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayStreamFilter implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int[] solution = solution(new int[]{49, 12, 100, 276, 33}, 27);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int[] arr, int n) {
        return IntStream.range(0, arr.length)
                .mapToObj(i -> {
                    if (arr.length % 2 != 0)
                        return i % 2 == 0 ? arr[i] + n : arr[i];
                    else {
                        return i % 2 != 0 ? arr[i] + n : arr[i];
                    }
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
