package algorithm.programmers.codingtest.crema;

import algorithm.TestCase;

import java.util.Comparator;
import java.util.List;

public class LongestSubarray implements TestCase {
    public static int maxLength(List<Integer> a, int k) {
        // Write your code here
//        int[] ints = new int[a.get(0)];
//        int constrain = a.get(a.get(0)+1);
//        System.out.println("constrain = " + constrain);
//        for (int i = 0; i < a.get(0); i++) {
//            ints[i] = a.get(i + 1);
//            System.out.println("i = " + ints[i]);
//        }
        a.sort(Comparator.naturalOrder());
        int result = 0;
        for (int i=0; i<a.size(); i++) {
            k -= a.get(i);
            if(k<=0) return result;
            result++;
        }
        return 0;
    }
    @Override
    public void test() {
    }
}
