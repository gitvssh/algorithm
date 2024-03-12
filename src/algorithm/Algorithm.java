package algorithm;

import algorithm.baek.etc.Warning;
import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {

    public static void main(String[] args) {

        Warning testCase = new Warning();
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
