package algorithm;

import algorithm.baek.twopointer.TwoArraySum;
import algorithm.programmers.level2.EndWord;
import algorithm.programmers.level2.PairDelete;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        TwoArraySum testCase = new TwoArraySum();
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
