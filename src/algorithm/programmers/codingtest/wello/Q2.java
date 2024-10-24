package algorithm.programmers.codingtest.wello;

import algorithm.TestCase;

import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;

public class Q2 implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BigInteger a = new BigInteger("235386");
        BigInteger b = new BigInteger("50000000");
        // a + b
        BigInteger sum = a.add(b);
        String string = sum.toString();
        System.out.println(string);
    }
}
