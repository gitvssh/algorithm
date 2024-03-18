package algorithm.baek.recursive;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Factorial implements TestCase {
    public static int factorial(int n) {
        if (n == 1) return 1;
        else return n * factorial(n - 1);
    }

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt("5");
        System.out.println(factorial(n));
    }
}

