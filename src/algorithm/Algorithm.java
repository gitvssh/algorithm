package algorithm;

import algorithm.baek.bfs.MazeSearch;
import algorithm.baek.dynamicprograming.ElectronicLine;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        MazeSearch testCase = new MazeSearch();

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
