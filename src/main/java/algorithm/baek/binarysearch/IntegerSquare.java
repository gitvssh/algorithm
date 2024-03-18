package algorithm.baek.binarysearch;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import lombok.extern.slf4j.Slf4j;

/**
 * https://www.acmicpc.net/problem/2417 정수 제곱근
 */
@Slf4j
public class IntegerSquare implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        log.info("result : {}", binarySearch(n));
    }

    public static long binarySearch(long n) {
        long result = 0;
        long start = 0;
        long end = n;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (n <= Math.pow(mid, 2)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}
