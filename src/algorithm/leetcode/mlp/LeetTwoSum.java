package algorithm.leetcode.mlp;

import algorithm.TestCase;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
        int[] result = new int[2];
        int length = nums.length;
        Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
        for (int i = 0; i < length - 1; i++) {
            if(map.containsKey(target-nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
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
