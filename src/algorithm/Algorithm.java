package algorithm;

import algorithm.baek.sort.MusicProgram;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        MusicProgram testCase = new MusicProgram();
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
