package algorithm.baek.dynamicprograming;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;

public class NotDecrease implements TestCase {

    int[][] dp = new int[65][10];

    /*
    분석(5m)
    설계(5m)
    구현(10m)

     */
    @Override
    public void test() throws ParseException, IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            bw.write(String.valueOf(getResult(Integer.parseInt(br.readLine()))));
            bw.newLine();
        }
        bw.close();
    }

    public void init(){
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i<= 64; i ++){
            for (int j = 0; j <= 9; j++) {
                dp[i][j] = 0;
                for(int k = 0; k <= j; k++){
                    dp[i][j] += dp[i-1][k];
                }
            }
        }
    }

    public int getResult(int n){
        int result = 0;
        for (int i = 0; i <= 9; i++) {
            result += dp[n][i];
        }
        return result;
    }
}
