package algorithm;

import algorithm.programmers.level1.Kbti;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        Kbti testCase = new Kbti();

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
