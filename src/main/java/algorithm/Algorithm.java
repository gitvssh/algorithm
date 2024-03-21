package algorithm;

import algorithm.baek.numbertheory.Plug;
import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {

    public static void main(String[] args) {

        Plug testCase = new Plug();
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
