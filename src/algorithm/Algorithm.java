package algorithm;

import algorithm.baek.bfs.AtoB;
import algorithm.baek.dfs.DiameterOfTree;
import algorithm.baek.recursive.Star11;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        Star11 testCase = new Star11();

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
