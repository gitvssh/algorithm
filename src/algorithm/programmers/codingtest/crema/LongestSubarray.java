package algorithm.programmers.codingtest.crema;

import algorithm.TestCase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestSubarray implements TestCase {
    public static int maxLength(List<Integer> a, int k) {
        int sum = a.stream().mapToInt(b->b).sum();
        int length = a.size();
        int result = 0;


        for (int i=0; i<length; i++) {

            int cnt = length-i;
            int localSum = sum;

            for (int j = length-1; j > i; j--) {
                if(k>=localSum){
                    result = Math.max(result, cnt);
                    System.out.println(result);
                }
                cnt--;
                localSum -= a.get(j);
            }
            sum-=a.get(i);
        }
        return result;
    }

    @Override
    public void test() {
    }
}
