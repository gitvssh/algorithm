package algorithm.euler;

import algorithm.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.text.ParseException;

@Slf4j
public class Problem001 implements TestCase {
    /*
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3,5,6 and9.
     * The sum of these multiples is 23.
     * Find the sum of all the multiples of 3 or 5 below 100.
     * */

    @Override
    public void test() throws ParseException, IOException {
        /*
         * 3,5로 나눴을 때 0인 수들 합 더하기
         *
         * */
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        log.info("result : {}", sum);
    }
}
