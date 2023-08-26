package algorithm;

import algorithm.baek.brute.PartialSum;
import algorithm.baek.etc.FishingKing;
import algorithm.baek.greedy.Bottle;
import algorithm.baek.string.AddSeven;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        Bottle testCase = new Bottle();
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
