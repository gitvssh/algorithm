package algorithm;

import algorithm.baek.etc.MyQueue;
import algorithm.baek.etc.PhoneBill;
import algorithm.baek.recursive.Hanoi;
import algorithm.baek.recursive.PrintStart;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        PhoneBill testCase = new PhoneBill();

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
