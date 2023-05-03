package algorithm;

import algorithm.baek.brute.CandyDoctor;
import algorithm.baek.etc.MineFinder;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashSet;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        CandyDoctor testCase = new CandyDoctor();
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
