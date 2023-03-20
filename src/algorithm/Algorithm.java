package algorithm;

import algorithm.baek.dynamicprograming.ElectronicLine;
import algorithm.baek.dynamicprograming.LCS;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        LCS testCase = new LCS();

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
