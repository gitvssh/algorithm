package algorithm;

import algorithm.baek.bfs.JumpJump;
import algorithm.baek.dfs.Alphabet;
import algorithm.baek.graph.FindingDistanceOfCity;
import algorithm.baek.graph.ShortCut;
import algorithm.baek.graph.SpecificShortestPath;
import algorithm.baek.numbertheory.KSezun;

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
