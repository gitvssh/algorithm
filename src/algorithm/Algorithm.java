package algorithm;

import algorithm.baek.cumulativesum.MultipleSum;
import algorithm.baek.cumulativesum.SumOfNumber;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        MultipleSum testCase = new MultipleSum();
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
