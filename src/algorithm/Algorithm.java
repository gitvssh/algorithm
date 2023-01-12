package algorithm;

import algorithm.baek.backtracking.NM1;
import algorithm.baek.etc.LittlePrince;
import algorithm.baek.numbertheory.BinomailCount;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        NM1 testCase = new NM1();

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
