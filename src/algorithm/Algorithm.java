package algorithm;

import algorithm.baek.bfs.HideAndSeek2;
import algorithm.baek.bfs.HideAndSeek3;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        HideAndSeek3 testCase = new HideAndSeek3();
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
