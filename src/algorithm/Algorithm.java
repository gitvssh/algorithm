package algorithm;

import algorithm.baek.bfs.Cheese;
import algorithm.baek.datastructure.Earring;
import algorithm.baek.datastructure.PostfixNotation;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        Earring testCase = new Earring();
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
