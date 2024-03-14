package algorithm;

import algorithm.baek.dynamicprograming.JumpJump;
import algorithm.baek.etc.Warning;
import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {

    public static void main(String[] args) {

        JumpJump testCase = new JumpJump();
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
