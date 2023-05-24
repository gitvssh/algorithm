package algorithm;

import algorithm.baek.dfs.DiameterOfTree;
import algorithm.baek.graph.TreeTraversalChange;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        TreeTraversalChange testCase = new TreeTraversalChange();
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
