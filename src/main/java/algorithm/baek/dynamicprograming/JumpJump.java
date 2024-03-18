package algorithm.baek.dynamicprograming;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JumpJump implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 2000);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int jump = arr[i];
            for (int j = i+1; j <= i+jump; j++) {
                if(j >= n) break;
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }

        if(dp[n-1] == 2000) {
            bw.write(-1 + "");
        }else {
            bw.write(dp[n-1] + "");
        }
        bw.close();
    }
}
