package algorithm;

import algorithm.baek.string.GuardDuty;
import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {

    public static void main(String[] args) {

        Object testCase = new GuardDuty();
        doTest(testCase);
    }


    public static void doTest(Object param) {
        if (!(param instanceof TestCase testCase)) {
            throw new ShCodingTestException("Test case must implement TestCase interface");
        }
        try {
            testCase.test();
        } catch (ParseException | IOException e) {
            throw new ShCodingTestException(e);
        }
    }
}
