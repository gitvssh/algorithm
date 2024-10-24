package algorithm.programmers.codingtest.wefun;

import algorithm.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Truck implements TestCase {
    public int solution(int M, int[] load) {
        int res = 0;
        Arrays.sort(load);
        if(load[load.length]>M) return -1;
//        return kSum(nums, target, 0, 4);
        return res;
    }
    private List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length) return res;
        long averageValue = target / k;
        if (nums[start] > averageValue || averageValue > nums[nums.length - 1]) return res;

        if (k == 2) return twoSum(nums, target, start);

        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }

        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start;
        int hi = nums.length - 1;

        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (currSum > target || (hi < nums.length - 1) && nums[hi] == nums[hi + 1]) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
            }
        }
        return res;
    }

    @Override
    public void test() {

    }
}
