package algorithm.baek.datastructure;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/4158 CD
 */
public class CD implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cdCounts = br.readLine().split(" ");
        int n = Integer.parseInt(cdCounts[0]);
        int m = Integer.parseInt(cdCounts[1]);
        int[] nArr = new int[n];
        int[] mArr = new int[m];
        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            mArr[i] = Integer.parseInt(br.readLine());
        }

        int nIdx = 0;
        int mIdx = 0;
        int dupCnt = 0;
        while (nIdx != n && mIdx != m) {
            if (nArr[nIdx] == mArr[mIdx]) {
                dupCnt++;
                nIdx++;
                mIdx++;
            } else if (nArr[nIdx] > mArr[mIdx]) {
                mIdx++;
            } else {
                nIdx++;
            }
        }
        System.out.println(dupCnt);
    }
}
