package algorithm;

import algorithm.baek.bfs.HideAndSeek2;
import algorithm.baek.datastructure.BinarySearchTree;
import algorithm.baek.dynamicprograming.GreenTop;
import algorithm.leetcode.daily.RansomNote;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        RansomNote testCase = new RansomNote();

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
