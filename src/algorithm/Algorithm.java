package algorithm;

import algorithm.baek.bfs.Dslr;
import algorithm.baek.cumulativesum.Atm;
import algorithm.baek.datastructure.Card1;
import algorithm.baek.dfs.RedGreenColorWeakness;
import algorithm.baek.dfs.Tetromino;
import algorithm.baek.dynamicprograming.FindPath;
import algorithm.baek.dynamicprograming.OneTwoThree;
import algorithm.baek.dynamicprograming.RGBDistance;
import algorithm.baek.dynamicprograming.TwoNTiling;
import algorithm.baek.etc.AC;
import algorithm.baek.etc.ThreeNumber;
import algorithm.baek.recursive.NumberOfPaper;
import algorithm.baek.set.FindPassword;
import algorithm.programmers.dfs.ShortestGameMap;
import algorithm.programmers.dfs.TargetNumber;
import algorithm.programmers.level1.MultipleArray;
import algorithm.programmers.level2.CountryOfNumber124;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        FindPath testCase = new FindPath();

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
