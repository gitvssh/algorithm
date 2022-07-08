package Algorithm.programmers.level1;

import Algorithm.TestCase;

import java.util.ArrayList;

public class Sum implements TestCase {
    @Override
    public void test() {
        int a = 3;
        int b = 5;
        int sum = 0;
        for (int i = a; i < b+1; i++) {
            sum+=i;
        }
        System.out.println("sum = " + sum);
    }
}
