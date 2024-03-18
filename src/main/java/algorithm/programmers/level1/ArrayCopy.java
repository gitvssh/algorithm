package algorithm.programmers.level1;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;

public class ArrayCopy implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int[] answer = {1,2,3,4,5};
        int[] res = Arrays.copyOfRange(answer, 0, 3);
        for (int re : res) {
            System.out.println("re = " + re);
        }

    }
}
