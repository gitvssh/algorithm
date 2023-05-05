package algorithm;

import algorithm.baek.etc.Reverse;
import algorithm.baek.sort.CountScore;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        CountScore testCase = new CountScore();
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
