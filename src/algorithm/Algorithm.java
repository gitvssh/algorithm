package algorithm;

import algorithm.baek.brute.MineCraft;
import algorithm.baek.etc.Digit;
import algorithm.baek.etc.FindEven;
import algorithm.baek.etc.MakeOne;
import algorithm.baek.etc.MyQueue;
import algorithm.baek.numbertheory.*;
import algorithm.programmers.level1.ArrayCopy;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        FindEven testCase = new FindEven();

        doTest(testCase);
    }

    public static void doTest(TestCase testCase) {
        try {
            testCase.test();
        } catch (ParseException | IOException e) {
            throw new ShCodingTestException(e);
        }
    }
}
