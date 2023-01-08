package algorithm;

import algorithm.baek.brute.MineCraft;
import algorithm.baek.etc.*;
import algorithm.baek.numbertheory.*;
import algorithm.programmers.level1.ArrayCopy;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        TaxiGeometry testCase = new TaxiGeometry();

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
