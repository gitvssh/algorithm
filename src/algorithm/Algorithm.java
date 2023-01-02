package algorithm;

import algorithm.baek.brute.MineCraft;
import algorithm.baek.etc.MakeOne;
import algorithm.baek.etc.MyQueue;
import algorithm.baek.numbertheory.BinomialCoefficient;
import algorithm.baek.numbertheory.BridgeMaker;
import algorithm.baek.numbertheory.FactorialCount;
import algorithm.baek.numbertheory.FashionKing;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        MakeOne testCase = new MakeOne();

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
