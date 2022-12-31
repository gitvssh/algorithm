package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class CuttingLan implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long line[] = new long[k];
        long max = 0;
        for(int i=0; i<k; i++) {
            line[i] = Integer.parseInt(br.readLine());
            max = Math.max(line[i], max);
        }
        max++;
        long min = 0, mid=0, cnt;
        while(min < max){
            mid = (max+min) / 2;
            cnt = 0;
            for(int i=0; i<k; i++)
                cnt += line[i] / mid;
            if(cnt < n)
                max = mid;
            else
                min = mid+1;
        }
        System.out.print(min-1);
    }
}
