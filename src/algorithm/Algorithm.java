package algorithm;

import algorithm.baek.datastructure.Card1;
import algorithm.baek.dynamicprograming.OneTwoThree;
import algorithm.baek.dynamicprograming.RGBDistance;
import algorithm.baek.etc.ThreeNumber;
import algorithm.baek.recursive.NumberOfPaper;
import algorithm.baek.set.FindPassword;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        Card1 testCase = new Card1();

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
