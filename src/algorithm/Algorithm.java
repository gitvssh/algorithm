package algorithm;

import algorithm.baek.bfs.Sibling;
import algorithm.baek.brute.NumSquare;
import algorithm.baek.greedy.MakeTriangle;
import algorithm.baek.greedy.WriteSequenceNum;
import algorithm.baek.sort.Prefix;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        Prefix testCase = new Prefix();
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
