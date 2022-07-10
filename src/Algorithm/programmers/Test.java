package Algorithm.programmers;

import Algorithm.TestCase;

public class Test implements TestCase {
    @Override
    public void test() {
        long n = 1;
        boolean b = (Math.sqrt(n) - (int) Math.sqrt(n)) == 0 ? true : false;

        System.out.println("b = " + b);
    }
}
