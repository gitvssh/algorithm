package algorithm.leetcode.studyplan75;

import algorithm.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;

//@Slf4j
public class RunningSum implements TestCase {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i];
        }
        return res;
    }

    @Override
    public void test() throws ParseException {
        int[] ints = runningSum(new int[]{1, 2, 3, 4});
        for (int anInt : ints) {
            //log.info("anInt = {}", anInt);
        }
    }
}

