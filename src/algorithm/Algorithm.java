package algorithm;

import algorithm.baek.etc.MineFinder;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashSet;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        MineFinder testCase = new MineFinder();
        doTest(testCase);
//        int solution = solution(new int[][]{{1, 4}, {9, 2}, {3, 8}, {11, 6}});
//        System.out.println(solution);
    }

    public static void doTest(TestCase testCase) {
        try {
            testCase.test();
        } catch (ParseException | IOException e) {
            throw new ShCodingTestException(e);
        }
    }
}
