package algorithm.programmers.codingtest.wefun;

import algorithm.TestCase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Insurance implements TestCase {
    //k는 아이템의 가지 수
    //t는 금액
    public int solution(int[] arr, int k, int t) {
        int res = 0;
        for (int i = k; i < arr.length; i++) {
            res += kSum(arr, t, 0, i);
        }
        return res;
    }

    private int kSum(int[] nums, int target, int start, int k) {
        if (k == 1) return twoSum(nums, target, start);

        int res = 0;
        for (int i = start; i < nums.length; ++i) {
            if (target - nums[i] > 0) {
                log.info("[>>>>] target : {}, start : {}, loop : {}", target, start, k);
                res += kSum(nums, target - nums[i], i + 1, k - 1);
                log.info("[<<<<] Otarget : {}, newTarget : {}, nowRes : {}", target, target - nums[i], res);
            }
        }

        return res;
    }

    public int twoSum(int[] nums, int target, int start) {
        log.info("[>>>>>>>>>] start : {}, target : {}", start, target);
        int res = 0;
        for (int i = start; i < nums.length; i++) {
            res += nums[i] <= target ? 1 : 0;
            log.info("inner logic :::  target : {}, nums : {}", target, nums[i]);
        }
        log.info("[<<<<<<<<]inner end : result : {} ", res);
        return res;
    }

    @Override
    public void test() {
        int solution = solution(new int[]{2, 5, 3, 8, 1}, 3, 11);
        log.info("result : {}", solution);
    }
}
