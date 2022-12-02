package algorithm;

import algorithm.baek.numbertheory.Ring;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        Ring testCase = new Ring();
        doTest(testCase);
    }

    public static void doTest(TestCase testCase) {
        try {
            testCase.test();
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
