package algorithm;

import algorithm.baek.cumulativesum.HumanComputer;
import algorithm.baek.cumulativesum.RemainderSum;
import algorithm.baek.etc.YoSePus;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        YoSePus testCase = new YoSePus();
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
