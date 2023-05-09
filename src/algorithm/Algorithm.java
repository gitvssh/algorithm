package algorithm;

import algorithm.baek.graph.FindingHer;
import algorithm.baek.graph.SeniorSearch;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        FindingHer testCase = new FindingHer();
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
