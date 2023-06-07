package algorithm;

import algorithm.baek.dfs.Alphabet;
import algorithm.baek.graph.SpecificShortestPath;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        SpecificShortestPath testCase = new SpecificShortestPath();
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
