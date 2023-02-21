package algorithm;

import algorithm.baek.bitmask.BitSet;
import algorithm.baek.etc.VerticalRead;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        VerticalRead testCase = new VerticalRead();

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
