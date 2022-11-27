package algorithm.leetcode.numbertheory;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class MultipleFactors implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0)
                break;
            if (m%n == 0){
                bw.write("factor");
            }else if(n%m == 0){
                bw.write("multiple");
            }else{
                bw.write("neither");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
