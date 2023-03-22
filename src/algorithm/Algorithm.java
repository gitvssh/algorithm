package algorithm;

import algorithm.baek.backtracking.MathClass;
import algorithm.baek.cumulativesum.ChessBoard;
import algorithm.baek.recursive.CantorSet;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        MathClass testCase = new MathClass();

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
