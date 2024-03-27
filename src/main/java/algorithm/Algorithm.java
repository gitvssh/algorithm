package algorithm;

import algorithm.baek.geometry.CircurmstancesOfCircle;
import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {

    public static void main(String[] args) {

        CircurmstancesOfCircle testCase = new CircurmstancesOfCircle();
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
