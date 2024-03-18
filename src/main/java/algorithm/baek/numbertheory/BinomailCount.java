package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class BinomailCount implements TestCase {
    @Override
    public void test() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int two = 0;
        int five = 0;
        for(int i=m;i>0;i--){
            two += countFactor(n-(m-i), 2);
            five += countFactor(n-(m-i), 5);
        }
        for(int i=m;i>0;i--){
            two -= countFactor(m-(m-i), 2);
            five -= countFactor(m-(m-i), 5);
        }
        System.out.println(Math.min(two, five));
    }

    public int countFactor(int n, int m){
        int count = 0;
        while(n>0){
            if(n%m==0) {
                count++;
                n /= m;
            }else{
                break;
            }
        }
        return count;
    }
}
