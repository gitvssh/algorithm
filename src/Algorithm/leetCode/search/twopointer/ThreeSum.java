package algorithm.leetcode.search.twopointer;

import algorithm.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum implements TestCase {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return twoPointer(nums, 0, 0);
    }

    private List<List<Integer>> twoPointer(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (start >= len) return res;
        for (int i = start; i < len - 2; ++i) {
            if (i == start || (nums[i] != nums[i - 1])) {
                for (List<Integer> subset : divisor(nums, target - nums[i], i + 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }
        return res;
    }

    private List<List<Integer>> divisor(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start;
        int hi = nums.length - 1;
        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (currSum > target || (nums.length - 1 > hi && nums[hi] == nums[hi + 1])) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
            }
        }
        return res;
    }

    @Override
    public void test() {
//        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> lists = threeSum(new int[]{0, 1, 1});
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println("integer = " + integer);
            }
        }
    }
}
