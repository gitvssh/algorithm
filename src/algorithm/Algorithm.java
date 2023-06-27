package algorithm;

import algorithm.baek.bfs.PipeMove;
import algorithm.baek.brute.ChickenDelivery;
import algorithm.baek.dynamicprograming.Descending;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        PipeMove testCase = new PipeMove();
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
