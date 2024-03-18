package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/1439
 * 뒤집기
 */
public class Reverse implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int zero = 0;
        int one = 0;
        if(s.charAt(0) == '0') zero++;
        else one++;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(i-1)){
                if(s.charAt(i) == '0') zero++;
                else one++;
            }
        }
        System.out.println(Math.min(zero, one));
    }
}
