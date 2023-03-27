package algorithm;

import algorithm.baek.dividenconquer.BiCoe;
import algorithm.baek.dividenconquer.Multiply;
import algorithm.baek.dynamicprograming.FourSquares;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        FourSquares testCase = new FourSquares();

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
