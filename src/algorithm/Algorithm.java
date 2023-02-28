package algorithm;

import algorithm.baek.backtracking.OperatorInserting;
import algorithm.baek.backtracking.StartAndLink;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        StartAndLink testCase = new StartAndLink();

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
