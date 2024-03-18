package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class FindEven implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            int min = Integer.MAX_VALUE;
            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                if(num % 2 == 0){
                    sum += num;
                    min = Math.min(min, num);
                }
            }
            bw.write(sum + " " + min);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
