package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

public class MakeOne implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(n!=1){
            if(n%3==0){
                n/=3;
                cnt++;
            }else if((n%2==0)&&((n-1)%3!=0)){
                n/=2;
                cnt++;
            }else{
                n--;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
