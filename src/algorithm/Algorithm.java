package algorithm;

import algorithm.baek.dynamicprograming.DanceDanceRevolution;
import algorithm.baek.sort.ThreeLiquid;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        ThreeLiquid testCase = new ThreeLiquid();
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
