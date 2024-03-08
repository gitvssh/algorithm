package algorithm;

import algorithm.baek.cumulativesum.WhiteBear;
import algorithm.baek.dynamicprograming.ShortCut;
import algorithm.baek.etc.DiceGame2;
import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {

    public static void main(String[] args) {

        DiceGame2 testCase = new DiceGame2();
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
