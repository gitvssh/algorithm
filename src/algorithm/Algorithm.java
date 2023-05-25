package algorithm;

import algorithm.baek.dfs.DiameterOfTree;
import algorithm.baek.graph.TreeTraversalChange;
import algorithm.baek.graph.WormHole;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        WormHole testCase = new WormHole();
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
