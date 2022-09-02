package algorithm.leetcode.mlp;

import algorithm.TestCase;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring implements TestCase {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        int left = 0;
        int right = 0;
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                maxLength = Math.max(maxLength, right - left);
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right++);
        }

        return Math.max(maxLength, right - left);
    }

    @Override
    public void test() {
        int result = lengthOfLongestSubstring("abcabcbb");
        System.out.println("result = " + result);
    }
}
