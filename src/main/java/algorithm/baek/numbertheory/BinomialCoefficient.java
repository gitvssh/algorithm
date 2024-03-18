package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class BinomialCoefficient implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=i; j++){
                if(j==0 || j==i) dp[i][j] = 1;
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
            }
        }
        bw.write(dp[n][k] + "");
        bw.flush();
        bw.close();
    }
}
