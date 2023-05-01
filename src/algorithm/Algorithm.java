package algorithm;

import algorithm.baek.etc.NumberOfPeople;
import algorithm.programmers.level0.Colatz;
import algorithm.programmers.level0.ConvertingArray;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        Colatz testCase = new Colatz();
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
