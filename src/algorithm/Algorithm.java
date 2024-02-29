package algorithm;

import algorithm.baek.etc.KoreanAge;
import algorithm.baek.etc.ModelStudent;
import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {

    public static void main(String[] args) {

        ModelStudent testCase = new ModelStudent();
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
