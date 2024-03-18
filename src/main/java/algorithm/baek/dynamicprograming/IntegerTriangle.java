package algorithm.baek.dynamicprograming;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class IntegerTriangle implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            for(int j=0;j<str.length;j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        dp[0][0] = arr[0][0];
        for(int i=1; i<n; i++){
            for(int j=0; j<=i; j++){
                if(j==0){
                    arr[i][j] += arr[i-1][j];
                }else if(j==i){
                    arr[i][j] += arr[i-1][j-1];
                }else{
                    arr[i][j] += Math.max(arr[i-1][j-1], arr[i-1][j]);
                }
            }
        }
        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, arr[n-1][i]);
        }
        System.out.println(max);
    }
}