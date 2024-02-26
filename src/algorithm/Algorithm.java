package algorithm;

import algorithm.baek.numbertheory.LuckyLetter;
import algorithm.baek.numbertheory.TeamReport;
import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {

    public static void main(String[] args) {

        TeamReport testCase = new TeamReport();
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
