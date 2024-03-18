package algorithm.baek.dynamicprograming;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class fibonacciNumber implements TestCase {
    public static int recursive = 0;
    public static int dp = 0;
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fibonacciRecur(n);
        fibonacciDP(n);
        System.out.println(recursive+" "+dp);
    }

    public long fibonacciRecur(int n){
        if(n==0){
            return 0;
        }else if(n==1){
            recursive++;
            return 1;
        }else{
            return fibonacciRecur(n-1)+fibonacciRecur(n-2);
        }
    }

    public long fibonacciDP(int n){
        long[] arr = new long[n+1];
        arr[1] = 1;
        arr[2] = 1;
        for(int i=3;i<=n;i++){
            dp++;
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}
