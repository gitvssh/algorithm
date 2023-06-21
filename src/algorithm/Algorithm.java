package algorithm;

import algorithm.baek.bfs.ByeByeDirt;
import algorithm.baek.bfs.JumpJump;
import algorithm.baek.bfs.Laboratory;
import algorithm.baek.dfs.Alphabet;
import algorithm.baek.etc.DDay;
import algorithm.baek.graph.FindingDistanceOfCity;
import algorithm.baek.graph.ShortCut;
import algorithm.baek.graph.SpecificShortestPath;
import algorithm.baek.numbertheory.KSezun;
import algorithm.baek.numbertheory.SumOfArray;
import algorithm.baek.string.StringBomb;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        SumOfArray testCase = new SumOfArray();
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
