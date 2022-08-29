package algorithm.leetcode.mlp;

import algorithm.TestCase;

import java.util.Arrays;

//@Slf4j
public class LeetTwoSum implements TestCase {
//    public int[] twoSum(int[] nums, int target) {
//        int length = nums.length;
//        for (int i = 0; i < length - 1; i++) {
//            for (int j = i + 1; j < length; j++) {
//                if (nums[i] + nums[j] == target)
//                    return new int[]{i, j};
//            }
//        }
//        return null;
//    }
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
//        int nTarget = target;
        Arrays.sort(nums);
        for (int i = 0; i < length - 1; i++) {
//            nTarget = target-i;
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return null;
    }
    @Override
    public void test() {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("ints = " + ints.toString());
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
//            log.info();
        }
    }
}
