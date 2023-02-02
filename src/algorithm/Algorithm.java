package algorithm;

import algorithm.baek.dynamicprograming.RGBDistance;
import algorithm.baek.etc.ThreeNumber;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        RGBDistance testCase = new RGBDistance();

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
