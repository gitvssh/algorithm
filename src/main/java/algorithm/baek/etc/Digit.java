package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Digit implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());
        if (i == 0) System.out.println(0);
        else {
            int s1 = Integer.parseInt(i + "", 8);
            System.out.println(Integer.toBinaryString(s1));
        }
    }
}
