package algorithm.leetcode.daily;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/ransom-note/
 */
public class RansomNote implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        System.out.println(canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ran = new HashMap();
        HashMap<Character, Integer> mag = new HashMap();
        for (int i = 0; i < ransomNote.length(); i++) {
            Character c = ransomNote.charAt(i);
            ran.put(c, ran.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < magazine.length(); i++) {
            Character c = magazine.charAt(i);
            mag.put(c, mag.getOrDefault(c, 0) + 1);
        }
        for (Character c : ran.keySet()) {
            if (!mag.containsKey(c) || ran.get(c) > mag.get(c)) return false;
        }
        return true;
    }
}
