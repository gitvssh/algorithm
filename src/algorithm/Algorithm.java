package algorithm;

import algorithm.baek.brute.PartialSum;
import algorithm.baek.etc.FishingKing;
import algorithm.baek.string.AddSeven;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        AddSeven testCase = new AddSeven();
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
