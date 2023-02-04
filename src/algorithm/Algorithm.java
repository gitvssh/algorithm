package algorithm;

import algorithm.baek.dynamicprograming.OneTwoThree;
import algorithm.baek.dynamicprograming.RGBDistance;
import algorithm.baek.etc.ThreeNumber;
import algorithm.baek.set.FindPassword;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        OneTwoThree testCase = new OneTwoThree();

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
