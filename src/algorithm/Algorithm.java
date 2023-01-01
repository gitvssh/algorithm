package algorithm;

import algorithm.baek.brute.MineCraft;
import algorithm.baek.etc.MyQueue;
import algorithm.baek.numbertheory.BinomialCoefficient;
import algorithm.baek.numbertheory.BridgeMaker;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        BridgeMaker testCase = new BridgeMaker();

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
