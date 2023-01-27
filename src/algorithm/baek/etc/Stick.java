package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class Stick implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x = 64;
        int count = 0;
        if(n == 64) {
            System.out.println(1);
            return;
        }
        while (x > 0) {
            if(n % x == 0) break;
            x /= 2;
            if(n>=x) {
                n -= x;
                count++;
            }
        }
        System.out.println(count);
    }
}
