package algorithm;

import algorithm.baek.dynamicprograming.*;
import algorithm.baek.recursive.QuadTree;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        LongestBytonicSequence testCase = new LongestBytonicSequence();

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
