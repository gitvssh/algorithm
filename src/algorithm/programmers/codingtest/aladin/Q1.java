package algorithm.programmers.codingtest.aladin;

import algorithm.TestCase;
import java.io.IOException;
import java.text.ParseException;

public class Q1 implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        int[] arr = {3, 4,1,5,4};
        int minProfit = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minProfit) {
                minProfit = arr[i];
            }
            if (arr[i] > maxProfit) {
                maxProfit = arr[i];
            }
        }
        if(maxProfit == minProfit){
            System.out.println(0);
            return;
        }
        System.out.println(maxProfit - minProfit);
        // 최소이익 = 최대값 - 최소값
    }
}
