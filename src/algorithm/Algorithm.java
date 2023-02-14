package algorithm;

import algorithm.baek.datastructure.CyclingQueue;
import algorithm.baek.dynamicprograming.IntegerTriangle;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        CyclingQueue testCase = new CyclingQueue();

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
