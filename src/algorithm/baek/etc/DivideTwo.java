package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class DivideTwo implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        n = (n / 100) * 100;
        System.out.println("n = " + n);
        int target = n;
        for (int i = 0; i <= 100; i++) {
            target = n + i;
            if (target % m == 0) {
                System.out.println(Integer.toString(target).substring(Integer.toString(target).length() - 2));
                return;
            }
        }
    }
}
