package algorithm.baek.dynamicprograming;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class LongestBytonicSequence implements TestCase {
    static int[] arr;
    static Integer[] dp1;
    static Integer[] dp2;
    static int n;
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp1 = new Integer[n];
        dp2 = new Integer[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        for (int i = 0; i < n; i++) {
            recur(i);
        }
        int max = dp1[0]+dp2[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp1[i]+dp2[i]);
        }
        System.out.println(max-1);
    }

    public static void recur(int curN) {
        if (dp1[curN] == null){
            dp1[curN] = 1;
            for (int i = curN-1; i >=0 ; i--) {
                if (arr[i] < arr[curN]){
                    recur(i);
                    dp1[curN] = Math.max(dp1[curN], dp1[i] + 1);
                }
            }
        }
        if(dp2[curN] == null){
            dp2[curN] = 1;
            for (int i = curN; i < n; i++) {
                if(arr[i] < arr[curN]){
                    recur(i);
                    dp2[curN] = Math.max(dp2[curN], dp2[i] + 1);
                }
            }
        }
    }
}
