package algorithm;

import algorithm.programmers.level1.NumberPair;
import algorithm.programmers.level1.WalkPark;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        WalkPark testCase = new WalkPark();

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
