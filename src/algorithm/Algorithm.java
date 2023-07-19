package algorithm;

import algorithm.baek.dynamicprograming.DanceDanceRevolution;
import algorithm.baek.graph.ACMCraft;
import algorithm.baek.sort.ThreeLiquid;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        ACMCraft testCase = new ACMCraft();
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
