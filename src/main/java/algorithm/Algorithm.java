package algorithm;

import algorithm.baek.graph.GoToTrip;
import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {

    public static void main(String[] args) {

        GoToTrip testCase = new GoToTrip();
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
