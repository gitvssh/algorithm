package algorithm;

import algorithm.euler.Problem002;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.text.ParseException;

@Slf4j
public class Algorithm {

    public static void main(String[] args) {
        Object testCase = new Problem002();
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
