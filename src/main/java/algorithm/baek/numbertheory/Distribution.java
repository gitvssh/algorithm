package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1009
 * 분산처리
 * 수학, 구현
 */
public class Distribution implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int i=0;i<tc;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int res = 1;
            while(b-- >0){
                res = res * a % 10;
            }
            if(res == 0) res = 10;
            bw.write(res+"\n");
        }
        bw.close();
    }
}
