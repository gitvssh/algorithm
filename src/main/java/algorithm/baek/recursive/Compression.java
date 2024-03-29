package algorithm.baek.recursive;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class Compression implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int fib = fibonacci(2);
    }

    private int fibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
