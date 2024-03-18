package algorithm.baek.cumulativesum;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.StringTokenizer;

public class WhiteBear implements TestCase {

    final int MAX_LENGTH = 2000001;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[1000001];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x]+=g;
        }
        int sum = 0;
        for (int i = 0; i < 1+2*k && i <= 1000000; i++) {
            sum += arr[i];
        }
        int max = sum;
        for (int i = 1+2*k, j = 0; i <= 1000000; i++, j++) {
            sum -= arr[j];
            sum += arr[i];
            if (sum > max)
                max = sum;
        }
        bw.write(max + "");
        bw.close();

    }
}
