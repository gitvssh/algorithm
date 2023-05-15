package algorithm;

import algorithm.baek.dividenconquer.FibonacciNumber6;
import algorithm.baek.graph.Beach;
import algorithm.baek.numbertheory.MatrixSquare;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        MatrixSquare testCase = new MatrixSquare();
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
