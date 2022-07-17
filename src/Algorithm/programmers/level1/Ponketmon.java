package algorithm.programmers.level1;

import algorithm.TestCase;

import java.util.Arrays;

public class Ponketmon implements TestCase {
    public int solution(int[] nums) {
        int[] ints = Arrays.stream(nums).distinct().sorted().toArray();
        return nums.length/2<ints.length?nums.length/2:ints.length;
    }
    @Override
    public void test() {
        int solution = solution(new int[]{3, 1, 2, 3});
    }
}
