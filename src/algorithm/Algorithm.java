package algorithm;

import algorithm.leetcode.studyplan75.RunningSum;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Algorithm {

    public static void main(String[] args) throws IOException {
        int keyboard =0;
        keyboard |= 1<<3;


        String ret = ((keyboard & (1 << 2)) == 0 ? "텐키리스" : "풀배열");
        log.info("{}", keyboard);
        log.info("{}", ret);
        keyboard &= ~(1 << 3);
        log.info("{}", keyboard);
        log.info("{}", Integer.toBinaryString(~(1 << 3)));

//        doTest(new RunningSum());
    }

    public static void doTest(TestCase testCase) {
        try {
            testCase.test();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
