package algorithm;

import algorithm.leetcode.studyplan75.RunningSum;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;

@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        TestCase testCase = new RunningSum();
        try {
            testCase.test();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
