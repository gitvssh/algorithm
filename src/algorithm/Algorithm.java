package algorithm;

import algorithm.baek.cumulativesum.WhiteBear;
import algorithm.baek.dynamicprograming.ShortCut;
import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {

    public static void main(String[] args) {

        WhiteBear testCase = new WhiteBear();
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
