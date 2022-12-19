package algorithm.baek.cumulativesum;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class RemainderSum implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        long result = 0;
        long[] s = new long[n + 1];
        long[] cnt = new long[m];

        for (int i = 1; i <= n; i++) {
            s[i] = (s[i - 1] + Integer.parseInt(st.nextToken())) % m;
            if (s[i] == 0) result++;
            cnt[(int) s[i]]++;
        }
        for (int i = 0; i < m; i++) {
            if (cnt[i] > 1) {
                result += (cnt[i] * (cnt[i] - 1) / 2);
            }
        }
        bw.write(result + "\n");
        bw.close();
    }
}
