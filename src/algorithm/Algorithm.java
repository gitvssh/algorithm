package algorithm;

import algorithm.baek.dynamicprograming.ElectronicLine;
import algorithm.baek.greedy.CoinZero;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        ElectronicLine testCase = new ElectronicLine();

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
